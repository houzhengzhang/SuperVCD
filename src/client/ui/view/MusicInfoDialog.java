/*
 * Created by JFormDesigner on Thu Oct 04 20:31:31 CST 2018
 */

package client.ui.view;

import java.awt.*;
import javax.swing.*;

/**
 * @author jframe
 */
public class MusicInfoDialog extends JDialog {
    public MusicInfoDialog(Frame owner) {
        super(owner);
        initComponents();
    }

    public MusicInfoDialog(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        panel2 = new JPanel();
        label2 = new JLabel();
        singerText = new JLabel();
        label4 = new JLabel();
        albumText = new JLabel();
        label7 = new JLabel();
        typeText = new JLabel();
        label8 = new JLabel();
        lengthText = new JLabel();
        label9 = new JLabel();
        priceText = new JLabel();
        albumImage = new JLabel();
        panel3 = new JPanel();
        scrollPane2 = new JScrollPane();
        infoTextArea = new JTextArea();
        label16 = new JLabel();
        panel4 = new JPanel();
        label15 = new JLabel();
        scrollPane1 = new JScrollPane();
        musicTable = new JTable();

        //======== this ========
        setTitle("\u8be6\u7ec6\u4fe1\u606f");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {62, 55, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {32, 28, 25, 29, 24, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- label2 ----
                label2.setText("\u6b4c\u624b\uff1a");
                label2.setHorizontalAlignment(SwingConstants.LEFT);
                panel2.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel2.add(singerText, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label4 ----
                label4.setText("\u4e13\u8f91\u540d\uff1a");
                label4.setHorizontalAlignment(SwingConstants.LEFT);
                panel2.add(label4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel2.add(albumText, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label7 ----
                label7.setText("\u7c7b\u578b\uff1a");
                label7.setHorizontalAlignment(SwingConstants.LEFT);
                panel2.add(label7, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel2.add(typeText, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label8 ----
                label8.setText("\u957f\u5ea6\uff1a");
                label8.setHorizontalAlignment(SwingConstants.LEFT);
                panel2.add(label8, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel2.add(lengthText, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label9 ----
                label9.setText("\u4ef7\u683c\uff1a");
                label9.setHorizontalAlignment(SwingConstants.LEFT);
                panel2.add(label9, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
                panel2.add(priceText, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panel1.add(panel2);
            panel2.setBounds(10, 0, 160, 140);

            //---- albumImage ----
            albumImage.setIcon(new ImageIcon("D:\\JavaProject\\SuperVCD\\src\\client\\resources\\d379526dc1ff624ed2c79527453d7dac.jpg"));
            panel1.add(albumImage);
            albumImage.setBounds(180, 10, 210, 165);

            //======== panel3 ========
            {
                panel3.setLayout(null);

                //======== scrollPane2 ========
                {

                    //---- infoTextArea ----
                    infoTextArea.setLineWrap(true);
                    infoTextArea.setEditable(false);
                    scrollPane2.setViewportView(infoTextArea);
                }
                panel3.add(scrollPane2);
                scrollPane2.setBounds(10, 35, 385, 105);

                //---- label16 ----
                label16.setText("\u6b4c\u624b\u7b80\u4ecb\uff1a");
                label16.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                panel3.add(label16);
                label16.setBounds(10, 0, 160, 27);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel3);
            panel3.setBounds(0, 175, 405, 140);

            //======== panel4 ========
            {
                panel4.setMaximumSize(null);
                panel4.setMinimumSize(new Dimension(335, 165));
                panel4.setLayout(null);

                //---- label15 ----
                label15.setText("\u4e13\u8f91\u5185\u6b4c\u66f2\u5217\u8868\uff1a");
                label15.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                panel4.add(label15);
                label15.setBounds(10, 0, 135, 27);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(musicTable);
                }
                panel4.add(scrollPane1);
                scrollPane1.setBounds(10, 32, 325, 140);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel4);
            panel4.setBounds(0, 320, 390, 215);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(10, 15, 405, 505);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label2;
    private JLabel singerText;
    private JLabel label4;
    private JLabel albumText;
    private JLabel label7;
    private JLabel typeText;
    private JLabel label8;
    private JLabel lengthText;
    private JLabel label9;
    private JLabel priceText;
    private JLabel albumImage;
    private JPanel panel3;
    private JScrollPane scrollPane2;
    private JTextArea infoTextArea;
    private JLabel label16;
    private JPanel panel4;
    private JLabel label15;
    private JScrollPane scrollPane1;
    private JTable musicTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JLabel getSingerText() {
        return singerText;
    }

    public JLabel getAlbumText() {
        return albumText;
    }

    public JLabel getTypeText() {
        return typeText;
    }

    public JLabel getLengthText() {
        return lengthText;
    }

    public JLabel getPriceText() {
        return priceText;
    }

    public JTable getMusicTable() {
        return musicTable;
    }

    public JTextArea getInfoTextArea() {
        return infoTextArea;
    }

    public JLabel getAlbumImage() {
        return albumImage;
    }
}
