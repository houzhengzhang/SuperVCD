package client.ui.view;

import javax.swing.*;

/**
 * @Auther: Administrator
 * @Date: 2018/10/2 18:33
 * @Description:
 */
public class MyButton extends JButton {

    private int row;

    private int column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public MyButton() {

    }

    public MyButton(String name) {
        super(name);
    }

}