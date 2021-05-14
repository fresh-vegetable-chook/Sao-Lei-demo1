import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaoLei extends JFrame implements ActionListener {
    ImageIcon imageIcon=new ImageIcon("saolei.jpg");
    ImageIcon imageIcon1=new ImageIcon("start3.jpg");
    ImageIcon imageIcon2=new ImageIcon("load.jpg");
    ImageIcon imageIcon3=new ImageIcon("option.jpg");
    ImageIcon imageIcon4=new ImageIcon("exit.jpg");

    JButton jButton=new JButton(imageIcon);
    JFrame frame = new JFrame();

    private JButton Game_Start;
    private JButton Game_Load;
    private JButton Game_Option;
    private JButton Game_Exit;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Game_Start){
            this.dispose();
            new OriginalFrame();
        }
        /*
        if (e.getSource()==Game_Load){
            this.dispose();
            new NewFrame2();
        }
        if (e.getSource()==Game_Option){
            this.dispose();
            new NewFrame3();
        }

         */
        if (e.getSource()==Game_Exit){
            this.dispose();
            System.exit(0);
        }
    }


    public SaoLei(String title) {              //构造方法
        frame.setTitle(title);//设置窗体的标题
        frame.setBounds(100, 100, 700, 800);
        //设置窗体左上角的位置坐标和窗体的大小，前两个数是位置坐标，后两个数是窗体大小，其单位均为像素

        frame.setBackground(Color.lightGray);        //设置窗体颜色
        frame.setResizable(false);                   //设置窗体为不可更改其大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗体关闭规则，EXIT_ON_CLOSE代表关闭窗体程序就结束
        frame.setLayout(new BorderLayout());         //设置布局

        setHead();
        frame.setVisible(true);

        setLayout(new FlowLayout());
        setLayout(new FlowLayout());
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(null);
        Game_Start = new JButton(imageIcon1);
        Game_Start.setBounds(0,100,700,180);
        frame.add(Game_Start);
        Game_Start.addActionListener(this);
        Game_Load = new JButton(imageIcon2);
        Game_Load.setBounds(0,280,700,180);
        frame.add(Game_Load);
        Game_Load.addActionListener(this);
        Game_Option = new JButton(imageIcon3);
        Game_Option.setBounds(0,460,700,160);
        frame.add(Game_Option);
        Game_Option.addActionListener(this);
        Game_Exit = new JButton(imageIcon4);
        Game_Exit.setBounds(0,620,700,180);
        frame.add(Game_Exit);
        Game_Exit.addActionListener(this);

        this.setVisible(true);

    }

    private void setHead(){
        frame.add(jButton,BorderLayout.NORTH);
        JPanel p=new JPanel(new GridBagLayout());
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
        jButton.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        /*
        j.setOpaque(true);
        j2.setOpaque(true);
        j3.setOpaque(true);
        j4.setOpaque(true);

         */



        frame.add(p,BorderLayout.NORTH);
        //JPanel panel=new Panel()
        /*JPanel panel=new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.weightx=1;
        gridBagConstraints.weighty=0;
        gridBagConstraints.gridwidth=3;
        gridBagConstraints.gridheight=1;
        gridBagConstraints.fill=GridBagConstraints.BOTH;
        gridBagConstraints.anchor=GridBagConstraints.CENTER;
        gridBagConstraints.insets=new Insets(0,0,0,0);
        gridBagConstraints.ipadx=0;
        gridBagConstraints.ipady=0;
        panel.add(jButton,gridBagConstraints);
         */



    }

    public static void main(String[] args) {
        new SaoLei("扫雷王");
    }
}
