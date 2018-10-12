package client.client;

import javax.sound.sampled.*;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class MusicPlayer {
    // 音频文件
    private String filePath;
    // 记录音频是否播放
    private volatile boolean run = true;
    // 线程退出标志
    private volatile boolean exit = false;
    //播放音频的任务线程
    private Thread mainThread = null;

    private AudioInputStream audioInputStream = null;
    private AudioFormat decodedFormat = null;
    private SourceDataLine sourceDataLine = null;

    private static MusicPlayer musicPlayer = null;

    public static MusicPlayer getMusicPlayer(String filename) {
        if (musicPlayer == null) {
            musicPlayer = new MusicPlayer(filename);
        } else {
            musicPlayer.setFilePath(filename);

        }
        return musicPlayer;
    }

    public static MusicPlayer getMusicPlayer() {
        if (musicPlayer == null) {
            return null;
        }
        return musicPlayer;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private MusicPlayer(String filename) {
        filePath = filename;
    }

    /**
     * 析构函数:关闭音频读取流和数据行
     *
     * @throws Throwable
     */
    protected void finalize() throws Throwable {
        super.finalize();
        sourceDataLine.drain();
        sourceDataLine.close();
        audioInputStream.close();
    }

    /**
     * 数据预处理
     */
    private void preFetch() {
        try {
            //获取音频输入流
            AudioInputStream rawAudioStream = AudioSystem.getAudioInputStream(new File(filePath));
            //获取音频的编码对象
            AudioFormat baseFormat = rawAudioStream.getFormat();
            // 定义音频格式
            decodedFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
                    baseFormat.getChannels() * 2, baseFormat.getSampleRate(),
                    false);
            // 使用format包装音频信息
            audioInputStream = AudioSystem.getAudioInputStream(decodedFormat, rawAudioStream);

            //使用包装音频信息后的format创建源数据行，充当混频器的源
            sourceDataLine = getLine(decodedFormat);

            // 开启源
            sourceDataLine.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    /**
     * 播放音频:通过loop参数设置是否循环播放
     *
     * @param loop
     */
    private void playMusic(boolean loop) {
        try {
            if (loop) {
                // 循环播放
                while (!exit) {
                    playMusic();
                }
            } else {
                playMusic();
                // 清空数据并关闭
                sourceDataLine.drain();
                sourceDataLine.close();
                audioInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playMusic() {
        try {
            synchronized (this) {
                run = true;
            }
            // 预处理音频文件
            preFetch();
            // 开辟缓存区
            byte[] data = new byte[4096];
            if (sourceDataLine != null) {
                int nBytesRead = 0;
                while ((nBytesRead = audioInputStream.read(data, 0, data.length)) != -1) {
                    synchronized (this) {
                        // 终止播放线程
                        if (exit) {
                            System.out.println("终止播放线程!");
                            return;
                        }
                        // 暂停播放
                        while (!run && !exit) {
                            // 阻塞
                            wait();
                        }
                    }
                    //通过数据行读取音频数据流，发送到混音器;
                    //数据流传输过程：AudioInputStream -> SourceDataLine;
                    if (nBytesRead != -1)
                        sourceDataLine.write(data, 0, nBytesRead);
                }
            }
        } catch (
                IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * 停止播放音频
     */
    private void stopMusic() {
        synchronized (this) {
            exit = true;
            notify();
        }
    }

    /**
     * 暂停播放音频
     */
    private void pauseMusic() {
        synchronized (this) {
            run = false;
            notify();
        }
    }

    /**
     * 继续播放音乐
     */
    private void continueMusic() {
        synchronized (this) {
            run = true;
            notifyAll();
        }
    }

    private SourceDataLine getLine(AudioFormat audioFormat) throws LineUnavailableException {
        SourceDataLine res = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        res = (SourceDataLine) AudioSystem.getLine(info);
        res.open(audioFormat);
        return res;
    }

    /**
     * 外部调用控制方法:生成音频主线程
     *
     * @param loop
     */
    public void start(boolean loop) {
        if (mainThread != null) {
            // 关闭之前的线程
            stopMusic();
            // TODO 防止死循环
            while (mainThread.isAlive()) {
                // 等待之前的线程关闭
            }
        }
        // 新开启线程
        mainThread = new Thread(new Runnable() {
            public void run() {
                playMusic(loop);
            }
        });
        exit = false;
        mainThread.start();

    }

    /**
     * 外部调用控制方法：终止音频线程
     */
    public void stop() {
        new Thread(new Runnable() {
            public void run() {
                stopMusic();
            }
        }).start();
    }

    /**
     * 外部调用控制方法：暂停音频线程
     */
    public void pause() {
        new Thread(new Runnable() {
            public void run() {
                pauseMusic();
            }
        }).start();
    }

    /**
     * 外部调用控制方法：继续音频线程
     */
    public void continues() {
        new Thread(new Runnable() {
            public void run() {
                continueMusic();
            }
        }).start();
    }

    public long getTime() {
        return sourceDataLine.getMicrosecondPosition();
    }

    public boolean getStatu() {
        return run;
    }

    public String getPath() {
        return this.filePath;
    }

    public static void main(String[] args) throws InterruptedException {
        MusicPlayer player = new MusicPlayer("D:\\JavaProject\\SuperVCD\\src\\main\\resources\\爱的代价.wav");
        player.start(true);
        TimeUnit.SECONDS.sleep(5);
        player.pause();                                          //暂停播放音频
        TimeUnit.SECONDS.sleep(4);
        player.continues();                            //继续开始播放音频


        TimeUnit.SECONDS.sleep(10);
        player.stop();                            //停止播放音频
    }

}