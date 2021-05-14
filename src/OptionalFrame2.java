import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionalFrame2 extends JFrame implements ActionListener {

    int ROW;
    int COL;
    int LEI;
    Frame frame=new Frame();



    public OptionalFrame2(int row, int col, int lei) {
        this.ROW=row;
        this.COL=col;
        this.LEI=lei;
        System.out.println(ROW);
        System.out.println(COL);
        System.out.println(LEI);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
