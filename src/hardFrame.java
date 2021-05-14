import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class hardFrame extends JFrame implements ActionListener, MouseListener {

    ImageIcon imageIcon = new ImageIcon("start5.jpg");
    ImageIcon backGround = new ImageIcon("background2.jpg");
    ImageIcon boom = new ImageIcon("lei2.jpg");
    ImageIcon flag = new ImageIcon("flag2.jpg");
    ImageIcon restart = new ImageIcon("restart3.jpg");
    JButton jButton = new JButton(imageIcon);
    JButton renew = new JButton(restart);
    JFrame frame = new JFrame();
    JPanel jPanel = new JPanel(new GridBagLayout());

    int LEI = 99;
    int LEICODE = -1;
    int ROW = 16;
    int COL = 30;
    int unopened = ROW * COL;
    int opened = 0;
    int seconds = 0;
    int[][] data = new int[ROW][COL];
    JButton[][] btns = new JButton[ROW][COL];

    JLabel jLabel = new JLabel("residue：" + unopened);
    JLabel jLabel1 = new JLabel("finish：" + opened);
    JLabel jLabel2 = new JLabel("time-consuming：" + seconds + "s");
    Timer timer = new Timer(1000, this);

    public hardFrame() {
        frame.setSize(1312, 850);
        frame.setLocation(5, 10);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("扫雷王-hard");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        hardShow();
        AddLei();
        AddGrid();
        timer.start();

    }

    private void hardShow() {
        jButton.setOpaque(true);
        jButton.setBorder(BorderFactory.createLineBorder(Color.lightGray));

        jLabel.setOpaque(true);
        jLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        jLabel.setBackground(Color.red);

        jLabel1.setOpaque(true);
        jLabel1.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        jLabel1.setBackground(Color.red);

        jLabel2.setOpaque(true);
        jLabel2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        jLabel2.setBackground(Color.red);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.ipady = 0;
        jPanel.add(jButton, gridBagConstraints);
        jButton.addActionListener(this);

        GridBagConstraints g1 = new GridBagConstraints();
        g1.gridx = 0;
        g1.gridy = 1;
        g1.weightx = 1;
        g1.weighty = 0;
        g1.gridwidth = 1;
        g1.gridheight = 1;
        g1.fill = GridBagConstraints.BOTH;
        g1.anchor = GridBagConstraints.CENTER;
        g1.insets = new Insets(0, 0, 0, 0);
        g1.ipadx = 0;
        g1.ipady = 0;
        jPanel.add(jLabel, g1);

        GridBagConstraints g2 = new GridBagConstraints();
        g2.gridx = 1;
        g2.gridy = 1;
        g2.weightx = 1;
        g2.weighty = 0;
        g2.gridwidth = 1;
        g2.gridheight = 1;
        g2.fill = GridBagConstraints.BOTH;
        g2.anchor = GridBagConstraints.CENTER;
        g2.insets = new Insets(0, 0, 0, 0);
        g2.ipadx = 0;
        g2.ipady = 0;
        jPanel.add(jLabel1, g2);

        GridBagConstraints g3 = new GridBagConstraints();
        g3.gridx = 2;
        g3.gridy = 1;
        g3.weightx = 1;
        g3.weighty = 0;
        g3.gridwidth = 1;
        g3.gridheight = 1;
        g3.fill = GridBagConstraints.BOTH;
        g3.anchor = GridBagConstraints.CENTER;
        g3.insets = new Insets(0, 0, 0, 0);
        g3.ipadx = 0;
        g3.ipady = 0;
        jPanel.add(jLabel2, g3);

        frame.add(jPanel, BorderLayout.NORTH);

    }

    private void AddGrid() {
        Container con = new Container();
        con.setLayout(new GridLayout(ROW, COL));

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                JButton button = new JButton(backGround);
                button.addActionListener(this);
                button.addMouseListener((MouseListener) this);
                button.setOpaque(true);
                button.setBackground(new Color(254, 67, 76));
                con.add(button);
                btns[i][j] = button;
            }
        }
        frame.add(con, BorderLayout.CENTER);
    }

    private void AddLei() {
        Random random = new Random();
        for (int i = 0; i < LEI; ) {
            int r = random.nextInt(ROW);
            int c = random.nextInt(COL);
            if (data[r][c] != LEICODE) {
                data[r][c] = LEICODE;
                i++;
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (data[i][j] == LEICODE)
                    continue;
                int count = 0;
                if (i > 0 && j > 0 && data[i - 1][j - 1] == LEICODE) count++;
                if (i > 0 && data[i - 1][j] == LEICODE) count++;
                if (i > 0 && j < 29 && data[i - 1][j + 1] == LEICODE) count++;
                if (j > 0 && data[i][j - 1] == LEICODE) count++;
                if (j < 29 && data[i][j + 1] == LEICODE) count++;
                if (j > 0 && i < 15 && data[i + 1][j - 1] == LEICODE) count++;
                if (i < 15 && data[i + 1][j] == LEICODE) count++;
                if (i < 15 && j < 29 && data[i + 1][j + 1] == LEICODE) count++;
                data[i][j] = count;
            }
        }
    }

    private void lose() {
        timer.stop();
        jButton.setIcon(restart);
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (btns[i][j].isEnabled()) {
                    if (data[i][j] == LEICODE) {
                        btns[i][j].setEnabled(false);
                        btns[i][j].setIcon(boom);
                        btns[i][j].setDisabledIcon(boom);
                    } else {
                        btns[i][j].setEnabled(false);
                        btns[i][j].setIcon(backGround);
                        btns[i][j].setDisabledIcon(backGround);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(frame, "step on a landmine, you lose!!!\n click there if you want" +
                " to play again!", "meet the landmine", JOptionPane.PLAIN_MESSAGE);
    }

    private void checkWin() {
        int count = 0;
        jButton.setIcon(restart);
        if (LEI==0){
            timer.stop();
            JOptionPane.showMessageDialog(frame, "Congratulation, You win!!!\n click there if you want" +
                    " to play again!", "Win", JOptionPane.PLAIN_MESSAGE);
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (btns[i][j].isEnabled()) count++;
            }
        }
        if (count == LEI) {
            timer.stop();
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (btns[i][j].isEnabled()) {
                        btns[i][j].setIcon(flag);
                    }
                }
            }
            JOptionPane.showMessageDialog(frame, "Congratulation, You win!!!\n click there if you want" +
                    " to play again!", "Win", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void lose2() {
        timer.stop();
        jButton.setIcon(restart);
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (btns[i][j].isEnabled()) {
                    if (data[i][j] == LEICODE) {
                        btns[i][j].setEnabled(false);
                        btns[i][j].setIcon(boom);
                        btns[i][j].setDisabledIcon(boom);
                    } else {
                        btns[i][j].setEnabled(false);
                        btns[i][j].setIcon(backGround);
                        btns[i][j].setDisabledIcon(backGround);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(frame, "there is no landmine, you lose!!!\n click there if you want" +
                " to play again!", "click the wrong location", JOptionPane.PLAIN_MESSAGE);
    }

    private void restart2() {
        Container con = new Container();
        con.setLayout(new GridLayout(ROW, COL));


        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                btns[i][j].setIcon(backGround);
                data[i][j] = 0;
                btns[i][j].setEnabled(true);
                btns[i][j].setBackground(new Color(254,67,76));
                con.add(btns[i][j], BorderLayout.CENTER);
            }
        }
        frame.add(con, BorderLayout.CENTER);
        AddLei();
        jButton.setIcon(imageIcon);
        timer.start();
        opened = 0;
        unopened = ROW * COL;
        seconds = 0;
        jLabel.setText("residue：" + unopened);
        jLabel1.setText("finish：" + opened);
        jLabel2.setText("time-consuming：" + seconds + "s");

    }


    private void updateCount(){
        opened++;
        unopened--;
        jLabel.setText("residue："+unopened);
        jLabel1.setText("finish："+opened);
    }

    private void restart(){
        Container container=new Container();
        container.setLayout(new GridLayout(ROW,COL));

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                btns[i][j].setIcon(backGround);
                btns[i][j].setText("");
                data[i][j]=0;
                btns[i][j].setEnabled(true);
                btns[i][j].setBackground(new Color(254,67,76));
                container.add(btns[i][j],BorderLayout.CENTER);
            }
        }
        frame.add(container,BorderLayout.CENTER);
        AddLei();
        jButton.setIcon(imageIcon);
        timer.start();
        opened=0;
        unopened=ROW*COL;
        seconds=0;
        jLabel.setText("residue："+unopened);
        jLabel1.setText("finish："+opened);
        jLabel2.setText("time-consuming："+seconds+"s");

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof Timer){
            seconds++;
            jLabel2.setText("time-consuming："+seconds+"s");
            timer.start();
            return;
        }

        JButton j=(JButton)e.getSource();
        if (j.equals(jButton)){
            restart();
            return;
        }
        for (int i = 0; i < ROW; i++) {
            for (int k = 0; k < COL; k++) {
                if (data[i][k] == LEICODE && opened == 0) {
                    if (j.equals(btns[i][k])) {
                        restart2();
                    }
                }
                else if (j.equals(btns[i][k])){
                    if (data[i][k]==LEICODE){
                        lose();
                    }
                    else {
                        j.setIcon(null);
                        j.setEnabled(false);
                        j.setOpaque(true);
                        j.setBackground(Color.GREEN);
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
