import javax.print.attribute.standard.JobName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OriginalFrame extends JFrame implements ActionListener {

    ImageIcon imageIcon=new ImageIcon("saolei.jpg");
    ImageIcon imageIcon1=new ImageIcon("select1.jpg");
    ImageIcon imageIcon2=new ImageIcon("select2.jpg");

    JButton jButton=new JButton(imageIcon);
    JButton jButton1=new JButton(imageIcon1);
    JButton jButton2=new JButton(imageIcon2);
    JFrame frame=new JFrame();

    private JButton choose_1;
    private JButton choose_2;

    public OriginalFrame(){
        frame.setTitle("扫雷王");
        frame.setSize(700,500);
        frame.setLocation(250,100);
        frame.setVisible(true);
        frame.setBackground(Color.cyan);
        frame.setLayout(new BorderLayout());
        setLayout(new FlowLayout());
        setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(null);
        jButton.setBounds(0,0,700,100);
        frame.add(jButton);
        choose_1=new JButton(imageIcon1);
        choose_1.addActionListener(this);
        choose_1.setBounds(0,100,700,200);
        frame.add(choose_1);
        choose_2=new JButton(imageIcon2);
        choose_2.addActionListener(this);
        choose_2.setBounds(0,300,700,200);
        frame.add(choose_2);

        this.setVisible(true);
    }

    private void setHead(){
        frame.add(jButton,BorderLayout.NORTH);
        JPanel p=new JPanel();
        GridBagConstraints g=new GridBagConstraints();
        g.gridx=0;
        g.gridy=0;
        g.weightx=0;
        g.weighty=1;
        g.gridwidth=1;
        g.gridheight=1;
        g.fill=GridBagConstraints.BOTH;
        g.anchor=GridBagConstraints.CENTER;
        g.insets=new Insets(0,0,0,0);
        g.ipadx=0;
        g.ipady=0;
        p.add(jButton,g);

        jButton.setOpaque(true);
        jButton.setBorder(BorderFactory.createLineBorder(Color.cyan));

        frame.add(p,BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==choose_1){
            this.dispose();
            new Newframe();
        }
        if (e.getSource()==choose_2){
            this.dispose();
            new Newframe2();
        }
    }
}
