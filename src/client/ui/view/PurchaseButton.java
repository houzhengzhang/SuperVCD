package client.ui.view;

import org.json.JSONObject;

import javax.swing.*;

/**
 * @Auther: Administrator
 * @Date: 2018/10/2 18:33
 * @Description:
 */
public class PurchaseButton extends JButton {

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

    public PurchaseButton() {

    }

    public PurchaseButton(String name) {
        super(name);
    }
    public PurchaseButton(String name, ImageIcon imageIcon) {
        super(name, imageIcon);
    }

}