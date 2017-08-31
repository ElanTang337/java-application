import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Whack-a-mole Game.
 * @author siyut
 */
public class Game extends JFrame {
    /**
     * Serial number.
     */
    private static final long serialVersionUID = 1L;
    /**
     * off string constant.
     */
    private static final String OFF_STRING = "Down";
    /**
     * on string constant.
     */
    private static final String UP_STRING = "UP";
    /**
     * hit string constant.
     */
    private static final String HIT_STRING = "Hitted!!";
    /**
     * off color constant.
     */
    private static final Color OFF_COLOR = Color.gray;
    /**
     * on color constant.
     */
    private static final Color UP_COLOR = Color.orange;
    /**
     * hit color constant.
     */
    private static final Color HIT_COLOR = Color.green;
    /**
     * the start button.
     */
    private JButton start;
    /**
     * the textField for displaying the time left.
     */
    private TextField timeLeftText;
    /**
     * the textField for displaying the score.
     */
    private TextField score;
    /**
     * buttons that represent moles.
     */
    private JButton[] buttons;
    /**
     * Random object to pick a button from the array.
     */
    private Random random = new Random();
    /**
     * the initial time.
     */
    private int timeRemain = 20;
    /**
     * a Runnable reference for running the timer.
     */
//    private Runnable timerRun;
    /**
     * a thread for running the timer.
     */
    private Thread timerThread;
  //  private int n;
    /**
     * the score of the player.
     */
    private int scoreNumber = 0;
    /**
     * the constructor of the Game.
     */
    public Game() {
        setTitle("Whack-a-mole Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        JPanel firstLine = new JPanel();
        JPanel moleZone = new JPanel(new GridLayout(8, 4));

        start = new JButton("Start");
        firstLine.add(start);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLeftText.setText("20");
                score.setText("");
                timeRemain = 20;
                scoreNumber = 0;
                start.setEnabled(false);
                timerThread = new Thread(new TimerRunnable());
                timerThread.start();
                for (int i = 0; i < 32; i++) {
                    MoleRunnable m = new MoleRunnable(i);
                    Thread t = new Thread(m);
                    t.start();
                }
            }
        });

        JLabel timeLeftLabel = new JLabel("Time Left");
        firstLine.add(timeLeftLabel);

        timeLeftText = new TextField(10);
        firstLine.add(timeLeftText);

        JLabel scoreLabel = new JLabel("Score");
        firstLine.add(scoreLabel);

        score = new TextField(10);
        firstLine.add(score);

        pane.add(firstLine);

        buttons = new JButton[32];
       // ActionListener mole = new moleActionListener();
        for (int i = 0; i < 32; i++) {
            buttons[i] = new JButton(OFF_STRING);
            buttons[i].setBackground(OFF_COLOR);
            buttons[i].setOpaque(true);
            moleZone.add(buttons[i]);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton) e.getSource();
 //                   synchronized (b) {
                        if (b.getText().equals(UP_STRING) && (timeRemain > 0)) {
                            b.setText(HIT_STRING);
                            b.setBackground(HIT_COLOR);
                            scoreNumber++;
                            score.setText(String.valueOf(scoreNumber));
                        }
//                    }
                }
            });
        }

        pane.add(moleZone);

        setContentPane(pane);
        setVisible(true);
    }
    /**
     * private nested class used to run a timer.
     * @author siyut
     */
    private class TimerRunnable implements Runnable {
        /**
         * implement run method of Runnable interface.
         */
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    if (timeRemain > 0) {
                        timeRemain = timeRemain - 1;
                        timeLeftText.setText(String.valueOf(timeRemain));
                    } else {
                       // System.out.println("test:" + timeRemain);
                        timeLeftText.setText("0");
                        Thread.sleep(5000);
                        start.setEnabled(true);
                        break;
                    }
                }
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
        }
    }
    /**
     * private nested class used to run a timer.
     * @author siyut
     */
    private class MoleRunnable implements Runnable {
        /**
         * a variable defined to finish the thread.
         */
        private boolean finished = false;
        /**
         * a method to finish the thread.
         */
        private void setFinish() {
            finished = true;
        }
        /**
         * the index of the buttons[].
         */
        private int index;
        /**
         * the constructor of the MoleRunnable.
         * @param i the index of the buttons[]
         */
        MoleRunnable(int i) {   //why the public modifier is redundant?
            index = i;
        }
        /**
         * implement run method of Runnable interface.
         */
        @Override
        public void run() {
            try {
                while (!finished) {
                    int randomTime = random.nextInt(3) + 1;
                    synchronized (buttons[index]) {
                        if (buttons[index].getText().equals(OFF_STRING) || timeRemain != 0) {
                            buttons[index].setText(UP_STRING);
                            buttons[index].setBackground(UP_COLOR);
                            Thread.sleep(randomTime * 1000);
                            buttons[index].setText(OFF_STRING);
                            buttons[index].setBackground(OFF_COLOR);
                            Thread.sleep(3000);
                        }
                    }
                        if (timeRemain == 0) {
                            setFinish();
                        }
                }
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
        }
    }
    /**
     * program to play the Whack-a-mole Game.
     * @param args argument of main method
     */
    public static void main(String[] args) {
        new Game();
    }
}
