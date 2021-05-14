import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Newframe extends JFrame implements ActionListener{

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


    public Newframe(){
        frame.setSize(1200,600);
        frame.setLocation(100,150);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("扫雷王");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        showImage();
    }

    JPanel panel=new JPanel(new GridBagLayout());

    public void showImage() {
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

        /*GridBagConstraints g=new GridBagConstraints();
        g.gridx=0;
        g.gridy=0;
        g.weightx=1;
        g.weighty=0;
        g.gridwidth=3;
        g.gridheight=1;
        g.fill=GridBagConstraints.BOTH;
        g.anchor=GridBagConstraints.CENTER;
        g.ipadx=0;
        g.ipady=0;
        panel.add(jButton,g);

        GridBagConstraints g1=new GridBagConstraints();
        g1.gridx=0;
        g1.gridy=1;
        g1.weightx=1;
        g1.weighty=0;
        g1.gridwidth=1;
        g1.gridheight=1;
        g1.fill=GridBagConstraints.BOTH;
        g1.anchor=GridBagConstraints.CENTER;
        g1.ipadx=0;
        g1.ipady=0;
        panel.add(j1,g1);

        GridBagConstraints g2=new GridBagConstraints();
        g2.gridx=1;
        g2.gridy=1;
        g2.weightx=1;
        g2.weighty=0;
        g2.gridwidth=1;
        g2.gridheight=1;
        g2.fill=GridBagConstraints.BOTH;
        g2.anchor=GridBagConstraints.CENTER;
        g2.ipadx=0;
        g2.ipady=0;
        panel.add(j2,g2);

        GridBagConstraints g3=new GridBagConstraints();
        g3.gridx=2;
        g3.gridy=1;
        g3.weightx=1;
        g3.weighty=0;
        g3.gridwidth=1;
        g3.gridheight=1;
        g3.fill=GridBagConstraints.BOTH;
        g3.anchor=GridBagConstraints.CENTER;
        g3.ipadx=0;
        g3.ipady=0;
        panel.add(j3,g3);
        frame.setVisible(true);
        frame.add(panel,BorderLayout.NORTH);
         */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==choose_easy){
            this.dispose();
            new easyFrame();
        }
        if (e.getSource()==choose_normal){
            this.dispose();
            new normalFrame();
        }
        if (e.getSource()==choose_hard){
            this.dispose();
            new hardFrame();
        }
        if (e.getSource()==choose_optional){
            this.dispose();
            new OptionalFrame();
        }
    }
}
