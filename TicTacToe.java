import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;




public class TicTacToe implements ActionListener
{
   JButton[] buttons = new JButton[9];
   JFrame frame = new JFrame();
   JPanel top = new JPanel();
   JPanel buttonP = new JPanel();
   JLabel textField = new JLabel();

   boolean player1_turn;

   TicTacToe()
   {

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(700, 700);
       frame.getContentPane().setBackground(new Color(50, 50, 50));
       frame.setLayout(new BorderLayout());
       frame.setVisible(true);

       top.setLayout(new BorderLayout());
       top.setBounds(0, 0, 700, 100);

       textField.setForeground(new Color(0, 0, 0));
       textField.setFont(new Font(".", 0, 80));
       textField.setHorizontalAlignment(JLabel.CENTER);
       textField.setText("Tic-Tac-Toe");

       buttonP.setLayout(new GridLayout(3, 3));
       buttonP.setBackground(new Color(150, 150, 150));

       for (int i = 0; i < 9; i++) {
           buttons[i] = new JButton();
           buttonP.add(buttons[i]);
           buttons[i].setFocusable(false);
           buttons[i].addActionListener(this);
           buttons[i].setFont(new Font("", Font.BOLD, 110));
       }

       top.add(textField);
       frame.add(top, BorderLayout.NORTH);
       frame.add(buttonP);

   }



   public void check() {
       //check X win conditions
       if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
           xW(0, 1, 2);
       }
       if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
           xW(3, 4, 5);
       }
       if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
           xW(6, 7, 8);
       }
       if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
           xW(0, 3, 6);
       }
       if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
           xW(1, 4, 7);
       }
       if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
           xW(2, 5, 8);
       }
       if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") &&(buttons[8].getText() == "X")) {
           xW(0, 4, 8);
       }
       if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
           xW(2, 4, 6);
       }
       //check O win conditions
       if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
           oW(0, 1, 2);
       }
       if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
           oW(3, 4, 5);
       }
       if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
           oW(6, 7, 8);
       }
       if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
           oW(0, 3, 6);
       }
       if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
           oW(1, 4, 7);
       }
       if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {

           oW(2, 5, 8);

       }
       if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
           oW(0, 4, 8);
       }
       if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
           oW(2, 4, 6);
       }
   }
boolean game_over = false;
   public void xW(int a, int b, int c) {
       buttons[a].setBackground(Color.GREEN);
       buttons[b].setBackground(Color.GREEN);
       buttons[c].setBackground(Color.GREEN);

       for (int i = 0; i < 9; i++)
       {
           buttons[i].setEnabled(false);
       }
       textField.setText("Player Wins!");
       game_over = true;
   }

   public void oW(int a, int b, int c) {
       buttons[a].setBackground(Color.GREEN);
       buttons[b].setBackground(Color.GREEN);
       buttons[c].setBackground(Color.GREEN);

       for (int i = 0; i < 9; i++)
       {
           buttons[i].setEnabled(false);
       }
       textField.setText("CPU Wins!");

   }

   public int cpuChoice()
   {
       Random rand = new Random();
       int random = rand.nextInt(9);
       return random;
   }
   public boolean notTie()
   {
       boolean notTie = false;

       if (checkAvailable() == false)
       {
           check();
           if (textField.getText() != "Player Turn!")
           {
               notTie = true;
           }
       }
       return notTie;
   }

       public boolean checkAvailable ()
       {
           boolean available = true;
           for (int i = 0; i < 9; i++)
           {
               if (buttons[i].getText() == "")
               {
                   available = true;
                   break;
               }
               else
               {
                   available = false;
               }
           }
           return available;
       }


       int CPU = cpuChoice();

       public void actionPerformed (ActionEvent e)
       {

           for (int i = 0; i < 9; i++)
           {
               if (e.getSource() == buttons[i])
               {
                   if (buttons[i].getText() == "")
                   {
                       buttons[i].setForeground(new Color(67, 191, 232));
                       buttons[i].setText("X");
                       check();
                       if(game_over) {
                           return;
                       }

                   }
                   else
                   {
                       return;
                   }
               }
           }
           try
           {
               Thread.sleep(200);
           }
           catch (InterruptedException a)
           {
               a.printStackTrace();
           }
           if (checkAvailable())
           {
               while (buttons[CPU].getText() != "")
               {
                   CPU = cpuChoice();
               }
               if (buttons[CPU].getText() == "")
               {
                   buttons[CPU].setForeground(new Color(251, 70, 70));
                   buttons[CPU].setText("O");
                   textField.setText("Player Turn!");
                   check();
               }
           }
           else if (notTie())
           {
               check();

           }
           else
           {
               textField.setText("Tie!");
           }
       }
   }

