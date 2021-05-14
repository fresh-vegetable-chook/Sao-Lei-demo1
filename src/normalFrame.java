import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class normalFrame extends JFrame implements ActionListener, MouseListener {

    ImageIcon imageIcon=new ImageIcon("saolei.jpg");
    ImageIcon backGround=new ImageIcon("background2.jpg");
    ImageIcon boom=new ImageIcon("lei2.jpg");
    ImageIcon flag=new ImageIcon("flag2.jpg");
    ImageIcon restart=new ImageIcon("restart2.jpg");
    JButton button=new JButton(imageIcon);
    JButton renew=new JButton(restart);
    JFrame frame=new JFrame();
    JPanel jPanel=new JPanel(new GridBagLayout());

    int ROW=16;
    int COL=16;
    int LEI=40;
    int LEICODE=-1;
    int unopened=ROW*COL;
    int opened=0;
    int seconds=0;
    int[][] data=new int[ROW][COL];
    JButton[][] btns=new JButton[ROW][COL];

    JLabel j1=new JLabel("residue："+unopened);
    JLabel j2=new JLabel("finish："+opened);
    JLabel j3=new JLabel("time-consuming："+seconds+"s");
    Timer timer=new Timer(1000,this);


    public normalFrame(){
        frame.setSize(700,800);
        frame.setLocation(100,50);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("扫雷王-normal");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        normalShow();
        AddLei();
        showGrid();
        timer.start();
    }

    private void normalShow(){
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        j1.setOpaque(true);
        j1.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        j1.setBackground(Color.yellow);

        j2.setOpaque(true);
        j2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        j2.setBackground(Color.yellow);

        j3.setOpaque(true);
        j3.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        j3.setBackground(Color.yellow);

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
        jPanel.add(button,gridBagConstraints);
        button.addActionListener(this);

        GridBagConstraints g1=new GridBagConstraints();
        g1.gridx=0;
        g1.gridy=1;
        g1.weightx=1;
        g1.weighty=0;
        g1.gridwidth=1;
        g1.gridheight=1;
        g1.fill=GridBagConstraints.BOTH;
        g1.anchor=GridBagConstraints.CENTER;
        g1.insets=new Insets(0,0,0,0);
        g1.ipadx=0;
        g1.ipady=0;
        jPanel.add(j1,g1);

        GridBagConstraints g2=new GridBagConstraints();
        g2.gridx=1;
        g2.gridy=1;
        g2.weightx=1;
        g2.weighty=0;
        g2.gridwidth=1;
        g2.gridheight=1;
        g2.fill=GridBagConstraints.BOTH;
        g2.anchor=GridBagConstraints.CENTER;
        g2.insets=new Insets(0,0,0,0);
        g2.ipadx=0;
        g2.ipady=0;
        jPanel.add(j2,g2);

        GridBagConstraints g3=new GridBagConstraints();
        g3.gridx=2;
        g3.gridy=1;
        g3.weightx=1;
        g3.weighty=0;
        g3.gridwidth=1;
        g3.gridheight=1;
        g3.fill=GridBagConstraints.BOTH;
        g3.anchor=GridBagConstraints.CENTER;
        g3.insets=new Insets(0,0,0,0);
        g3.ipadx=0;
        g3.ipady=0;
        jPanel.add(j3,g3);

        frame.add(jPanel,BorderLayout.NORTH);

    }

    private void AddLei(){
        Random random=new Random();
        for (int i = 0; i < LEI;) {
            int r=random.nextInt(ROW);
            int c=random.nextInt(COL);
            if (data[r][c]!=LEICODE){
                data[r][c]=LEICODE;
                i++;
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (data[i][j]==LEICODE)
                    continue;
                int count=0;
                if (i>0&&j>0&&data[i-1][j-1]==LEICODE) count++;
                if (i>0&&data[i-1][j]==LEICODE) count++;
                if (i>0&&j<15&&data[i-1][j+1]==LEICODE) count++;
                if (j>0&&data[i][j-1]==LEICODE) count++;
                if (j<15&&data[i][j+1]==LEICODE) count++;
                if (i<15&&j>0&&data[i+1][j-1]==LEICODE) count++;
                if (i<15&&data[i+1][j]==LEICODE) count++;
                if (i<15&&j<15&&data[i+1][j+1]==LEICODE) count++;
                data[i][j]=count;
            }
        }
    }

    private void showGrid(){
        Container container=new Container();
        container.setLayout(new GridLayout(ROW,COL));

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                JButton jButtons=new JButton(backGround);
                jButtons.addActionListener(this);
                jButtons.addMouseListener((MouseListener)this);
                jButtons.setOpaque(true);
                jButtons.setBackground(new Color(246,254,124));
                container.add(jButtons);
                btns[i][j]=jButtons;
            }
        }
        Add(container);
    }

    private void Add(Container container){
        frame.add(container,BorderLayout.CENTER);
    }

    private void lose(){
        timer.stop();
        button.setIcon(restart);
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (btns[i][j].isEnabled()){
                    if (data[i][j]==LEICODE){
                        btns[i][j].setEnabled(false);
                        btns[i][j].setIcon(boom);
                        btns[i][j].setDisabledIcon(boom);
                    }
                    else {
                        btns[i][j].setEnabled(false);
                        btns[i][j].setIcon(backGround);
                        btns[i][j].setDisabledIcon(backGround);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(frame,"step on a landmine, you lose!!!\n click there if you want" +
                " to play again!","meet the landmine",JOptionPane.PLAIN_MESSAGE);
    }

    private void lose2(){
        timer.stop();
        button.setIcon(restart);
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (btns[i][j].isEnabled()){
                    if (data[i][j]==LEICODE){
                        btns[i][j].setEnabled(false);
                        btns[i][j].setIcon(boom);
                        btns[i][j].setDisabledIcon(boom);
                    }
                    else {
                        btns[i][j].setEnabled(false);
                        btns[i][j].setIcon(backGround);
                        btns[i][j].setDisabledIcon(backGround);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(frame,"there is no landmine, you lose!!!\n click there if you want" +
                " to play again!","click the wrong location",JOptionPane.PLAIN_MESSAGE);
    }

    private void checkWin(){
        int count=0;
        button.setIcon(restart);
        if (LEI==1) {
            timer.stop();
            JOptionPane.showMessageDialog(frame, "Congratulation, You win!!!\n click there if you want" +
                    " to play again!", "Win", JOptionPane.PLAIN_MESSAGE);
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (btns[i][j].isEnabled()) count++;
            }
        }
        if (count==LEI){
            timer.stop();
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (btns[i][j].isEnabled()){
                        btns[i][j].setIcon(flag);
                    }
                }
            }
            JOptionPane.showMessageDialog(frame,"Congratulation, You win!!!\n click there if you want" +
                    " to play again!","Win",JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void updateCount(){
        opened++;
        unopened--;
        j1.setText("residue："+unopened);
        j2.setText("finish："+opened);
    }

    private void restart(){
        Container con=new Container();
        con.setLayout(new GridLayout(ROW,COL));

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                data[i][j]=0;
                btns[i][j].setIcon(backGround);
                btns[i][j].setEnabled(true);
                btns[i][j].setText("");
                btns[i][j].setBackground(new Color(246,254,124));
                con.add(btns[i][j],BorderLayout.CENTER);
            }
        }
        Add(con);
        AddLei();
        button.setIcon(imageIcon);
        timer.start();
        opened=0;
        unopened=ROW*COL;
        seconds=0;
        j1.setText("residue："+unopened);
        j2.setText("finish："+opened);
        j3.setText("time-consuming："+seconds+"s");
    }

    private void restart2(){
        Container con=new Container();
        con.setLayout(new GridLayout(ROW,COL));


        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                btns[i][j].setIcon(backGround);
                data[i][j]=0;
                btns[i][j].setEnabled(true);
                btns[i][j].setBackground(new Color(246,254,124));
                con.add(btns[i][j],BorderLayout.CENTER);
            }
        }
        frame.add(con,BorderLayout.CENTER);
        AddLei();
        button.setIcon(imageIcon);
        timer.start();
        opened=0;
        unopened=ROW*COL;
        seconds=0;
        j1.setText("residue："+unopened);
        j2.setText("finish："+opened);
        j3.setText("time-consuming："+seconds+"s");

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof Timer){
            seconds++;
            j3.setText("time-consuming："+seconds+"s");
            timer.start();
            return;
        }

        JButton j=(JButton)e.getSource();
        if (j.equals(button)){
            restart();
            return;
        }
        for (int i = 0; i < ROW; i++) {
            for (int k = 0; k < COL; k++) {
                if (data[i][k]==LEICODE&&opened==0) {
                    if (j.equals(btns[i][k])){
                        restart2();
                    }
                }
                else if (j.equals(btns[i][k])) {
                    if (data[i][k] == LEICODE) {
                        lose();
                    } else {
                        j.setIcon(null);
                        j.setEnabled(false);
                        j.setOpaque(true);
                        j.setBackground(Color.yellow);
                        j.setText(data[i][k] + "");
                        updateCount();
                        checkWin();
                    }
                    return;
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton jButton=(JButton)e.getSource();
        if (e.getButton()==MouseEvent.BUTTON3) {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (jButton.equals(btns[i][j])) {
                        if (btns[i][j].isEnabled()) {
                            if (data[i][j] == LEICODE) {
                                btns[i][j].setIcon(flag);
                                LEI--;
                                checkWin();
                            }
                            else lose2();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
