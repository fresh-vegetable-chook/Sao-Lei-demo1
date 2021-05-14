import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Newframe2 extends JFrame implements ActionListener {

    ImageIcon imageIcon=new ImageIcon("start4.jpg");
    ImageIcon imageIcon1=new ImageIcon("esay.jpg");
    ImageIcon imageIcon2=new ImageIcon("normal.jpg");
    ImageIcon imageIcon3=new ImageIcon("hard.jpg");
    ImageIcon imageIcon4=new ImageIcon("optional.jpg");
    JButton jButton=new JButton(imageIcon);
    JLabel j1=new JLabel(imageIcon1);
    JLabel j2=new JLabel(imageIcon2);
    JLabel j3=new JLabel(imageIcon3);
    JFrame frame=new JFrame();

    private JButton choose_easy;
    private JButton choose_normal;
    private JButton choose_hard;
    private JButton choose_optional;

    JPanel panel=new JPanel(new GridBagLayout());


    public Newframe2(){
        frame.setSize(1200,600);
        frame.setLocation(100,150);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("扫雷王");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        showImage();
    }

    private void showImage(){
        frame.setLayout(null);
        jButton.setBounds(0,0,1200,200);
        jButton.setBackground(new Color(106,66,32));
        frame.add(jButton,BorderLayout.NORTH);
        choose_easy=new JButton(imageIcon1);
        choose_easy.setBounds(0,200,300,400);
        frame.add(choose_easy);
        choose_easy.addActionListener(this);
        choose_normal=new JButton(imageIcon2);
        choose_normal.setBounds(300,200,300,400);
        frame.add(choose_normal);
        choose_normal.addActionListener(this);
        choose_hard=new JButton(imageIcon3);
        choose_hard.setBounds(600,200,300,400);
        frame.add(choose_hard);
        choose_hard.addActionListener(this);
        choose_optional=new JButton(imageIcon4);
        choose_optional.setBounds(900,200,300,400);
        frame.add(choose_optional);
        choose_optional.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==choose_easy){
            this.dispose();
            //new doubleEasyFrame();
        }
        if (e.getSource()==choose_normal){
            this.dispose();
            //new doubleNormalFrame();
        }
        if (e.getSource()==choose_hard){
            this.dispose();
            //new doubleHardFrame();
        }
        if (e.getSource()==choose_optional){
            this.dispose();
            //new doubleOptionalFrame();
        }
    }
}
