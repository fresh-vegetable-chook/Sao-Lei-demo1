import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class OptionalFrame extends JFrame implements ActionListener {

    JFrame jf=new JFrame();

    JPanel jp = new JPanel();
    JButton jButton=new JButton("complete setting");
    JLabel title=new JLabel("input the number of rows: ");
    JLabel title2=new JLabel("input the number of column: ");
    JLabel title3=new JLabel("input the number of boom: ");
    JTextField textField = new JTextField(20);
    JTextField textField2 = new JTextField(20);
    JTextField textField3 = new JTextField(20);


    public OptionalFrame() {
        jf.setTitle("input windows");
        jf.setSize(300, 500);
        jf.setLocation(300, 200);

        jf.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
        jf.add(jp);
        jf.add(title);
        jf.add(textField);
        jf.add(title2);
        jf.add(textField2);
        jf.add(title3);
        jf.add(textField3);
        jf.add(jButton);
        jButton.addActionListener(this);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String row=textField.getText().trim();
        int ROW=Integer.parseInt(row);
        String col=textField2.getText().trim();
        int COL=Integer.parseInt(col);
        String lei=textField3.getText().trim();
        int LEI=Integer.parseInt(lei);
        JOptionPane.showMessageDialog(null,"setting rows complete! ");
        JOptionPane.showMessageDialog(null,"setting columns complete! ");
        JOptionPane.showMessageDialog(null,"setting booms complete! ");
        if (ROW>0&&ROW<=24&&COL>0&&COL<=30&&LEI>0&&LEI<(int)((ROW*COL)/2)){
            new OptionalFrame2(ROW,COL,LEI);
        }
    }
}
