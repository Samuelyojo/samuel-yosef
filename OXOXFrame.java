import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

public class OXOXFrame extends JFrame {
    JButton []buttons;
    int turnCount = 0;

        ImageIcon originalIconX = new ImageIcon("x.png");
        java.awt.Image scaledImageX = originalIconX.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        ImageIcon xIcon = new ImageIcon(scaledImageX);

        ImageIcon originalIconO = new ImageIcon("o.png");
        java.awt.Image scaledImageO = originalIconO.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        ImageIcon oIcon = new ImageIcon(scaledImageO);

 
    public OXOXFrame() {
        buttons = new JButton[9];
        
        for(int i = 0; i < 9 ;i++){
        final int index = i;
        buttons[index] = new JButton();
        buttons[index].addActionListener(e -> {
          if(buttons[index].getIcon() == null) { 
            if (turnCount % 2 == 0) {
                buttons[index].setIcon(xIcon);;
            } else {
                buttons[index].setIcon(oIcon);;
            }
             turnCount++;
            checkWinner();
           
        }
            
        });  
        }


      
        for(int i = 0; i < 9 ; i++){
            final int index = i;
            add(buttons[index]);
        }

        setTitle("OXOX");
        setSize(400, 300);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    void checkWinner(){
        if(buttons[0].getIcon() != null && buttons[0].getIcon().equals( buttons[1].getIcon()) && buttons[1].getIcon().equals( buttons[2].getIcon())){
            announceWinner(buttons[0].getIcon());
            resetBord();
        }else if(buttons[3].getIcon() != null && buttons[3].getIcon().equals( buttons[4].getIcon()) && buttons[4].getIcon().equals( buttons[5].getIcon())){
            announceWinner(buttons[3].getIcon());
            resetBord();
        }else if(buttons[6].getIcon() != null && buttons[6].getIcon().equals( buttons[7].getIcon()) && buttons[7].getIcon().equals( buttons[8].getIcon())){
            announceWinner(buttons[6].getIcon());
            resetBord();
        }else if(buttons[0].getIcon() != null && buttons[0].getIcon().equals( buttons[3].getIcon()) && buttons[3].getIcon().equals( buttons[6].getIcon())){
            announceWinner(buttons[0].getIcon());
            resetBord();
        }else if(buttons[1].getIcon() != null && buttons[1].getIcon().equals( buttons[4].getIcon()) && buttons[4].getIcon().equals( buttons[7].getIcon())){
            announceWinner(buttons[1].getIcon());
            resetBord();
        }else if(buttons[2].getIcon() != null && buttons[2].getIcon().equals( buttons[5].getIcon()) && buttons[5].getIcon().equals( buttons[8].getIcon())){
            announceWinner(buttons[2].getIcon());
            resetBord();
        }else if(buttons[0].getIcon() != null && buttons[0].getIcon().equals( buttons[4].getIcon()) && buttons[4].getIcon().equals( buttons[8].getIcon())){
            announceWinner(buttons[0].getIcon());
            resetBord();
        }else if(buttons[2].getIcon() != null && buttons[2].getIcon().equals( buttons[4].getIcon()) && buttons[4].getIcon().equals( buttons[6].getIcon())){
            announceWinner(buttons[2].getIcon());
            resetBord();
        }else if(turnCount == 9){
            JOptionPane.showMessageDialog(null, "Draw " );
            resetBord();
        }
    }

    void resetBord(){
        buttons[0].setIcon(null);
        buttons[1].setIcon(null);
        buttons[2].setIcon(null);
        buttons[3].setIcon(null);
        buttons[4].setIcon(null);
        buttons[5].setIcon(null);
        buttons[6].setIcon(null);
        buttons[7].setIcon(null);
        buttons[8].setIcon(null);
        turnCount = 0;
    }

    void announceWinner(javax.swing.Icon winningIcon) {
        String winnerLabel = (winningIcon == xIcon) ? "X" : "O";
        JOptionPane.showMessageDialog(null, "Winner is : " + winnerLabel);
        resetBord();
    }
}
