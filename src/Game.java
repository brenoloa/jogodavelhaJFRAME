import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game {
    JButton[] botao = new JButton[9];
    boolean xo = false;
    boolean[] click = new boolean[9];
    public Game() {
        JFrame tela = new JFrame("Jogo da Velha");
        tela.setSize(330, 450);   
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);
        
        tela.setDefaultCloseOperation(3);
        tela.setLayout(null);
       
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botao[cont] = new JButton();
                botao[cont].setBounds((100 * i) + 10, (100 * j) + 10, 95, 95);
                botao[cont].setBackground(new Color(80, 78, 78));
                botao[cont].setForeground(new Color(255, 255, 255));
                botao[cont].setText("");
                botao[cont].setFont(new Font("ARIAL", Font.BOLD, 50));
                tela.add(botao[cont]);
                
                cont++;
            }
            
        }
        
        //  BOTOES
        botao[0].addActionListener(this::botao0);
        botao[1].addActionListener(this::botao1);
        botao[2].addActionListener(this::botao2);
        botao[3].addActionListener(this::botao3);
        botao[4].addActionListener(this::botao4);
        botao[5].addActionListener(this::botao5);
        botao[6].addActionListener(this::botao6);
        botao[7].addActionListener(this::botao7);
        botao[8].addActionListener(this::botao8);

        for (int i = 0; i < 9; i++){
                click[i] = false;
            }
            
        tela.setVisible(true);
    }
        
    public void mudar(JButton btn, int index) {
        // Apenas alterar o botão se ele estiver vazio
        if (btn.getText().equals("")) {
            if (xo) {
                btn.setText("O");
                btn.setBackground(Color.BLUE);  
                xo = false;
            } else {
                btn.setText("X");
                btn.setBackground(Color.RED);   
                xo = true;
            }
            click[index] = true; 
            ganhou(); 
        }
    }
    
    //funcoes dos botoes
    public void botao0(ActionEvent e) {
        if (click[0] == false){
            mudar(botao[0], 0);
            click[0] = true;
        }
    }
    public void botao1(ActionEvent e) {
        if (click[1] == false){
            mudar(botao[1], 1);
            click[1] = true;
        }
    }
    public void botao2(ActionEvent e) {
        if (click[2] == false){
            mudar(botao[2], 2);
            click[2] = true;
        }
    }
    public void botao3(ActionEvent e) {
        if (click[3] == false){
            mudar(botao[3], 3);
            click[3] = true;
        }
    }
    public void botao4(ActionEvent e) {
        if (click[4] == false){
            mudar(botao[4], 4);
            click[4] = true;
        }
    }
    public void botao5(ActionEvent e) {
        if (click[5] == false){
            mudar(botao[5], 5);
            click[5] = true;
        }
    }
    
    public void botao6(ActionEvent e) {
        if (click[6] == false){
            mudar(botao[6], 6);
            click[6] = true;
        }
    }
    public void botao7(ActionEvent e) {
        if (click[7] == false){
            mudar(botao[7], 7);
            click[7] = true;
        }
    }
    public void botao8(ActionEvent e) {
        if (click[8] == false){
            mudar(botao[8], 8);
            click[8] = true;
        }
    }
    
    // LOGICA DE JOGO

    public void ganhou() {
        int cont2 = 0;
        for (int i = 0; i < 9; i++) {
            if (click[i] == true){
                cont2++;
            }
            
        }
        
        if ((botao[0].getText().equals("X") && botao[1].getText().equals("X") && botao[2].getText().equals("X"))
        || (botao[3].getText().equals("X") && botao[4].getText().equals("X") && botao[5].getText().equals("X"))
        || (botao[6].getText().equals("X") && botao[7].getText().equals("X") && botao[8].getText().equals("X"))
        || (botao[0].getText().equals("X") && botao[3].getText().equals("X") && botao[6].getText().equals("X"))
        || (botao[1].getText().equals("X") && botao[4].getText().equals("X") && botao[7].getText().equals("X"))
        || (botao[2].getText().equals("X") && botao[5].getText().equals("X") && botao[8].getText().equals("X"))
        || (botao[0].getText().equals("X") && botao[4].getText().equals("X") && botao[8].getText().equals("X"))
        || (botao[6].getText().equals("X") && botao[4].getText().equals("X") && botao[2].getText().equals("X"))) {
            JOptionPane.showMessageDialog(null, "X VENCEU!");
            limpar();
        } 
        else if ((botao[0].getText().equals("O") && botao[1].getText().equals("O") && botao[2].getText().equals("O"))
        || (botao[3].getText().equals("O") && botao[4].getText().equals("O") && botao[5].getText().equals("O"))
        || (botao[6].getText().equals("O") && botao[7].getText().equals("O") && botao[8].getText().equals("O"))
        || (botao[0].getText().equals("O") && botao[3].getText().equals("O") && botao[6].getText().equals("O"))
        || (botao[1].getText().equals("O") && botao[4].getText().equals("O") && botao[7].getText().equals("O"))
        || (botao[2].getText().equals("O") && botao[5].getText().equals("O") && botao[8].getText().equals("O"))
        || (botao[0].getText().equals("O") && botao[4].getText().equals("O") && botao[8].getText().equals("O"))
        || (botao[6].getText().equals("O") && botao[4].getText().equals("O") && botao[2].getText().equals("O"))) {
            JOptionPane.showMessageDialog(null, "O VENCEU!");
            limpar();
        }
        else if (cont2 == 9){
            JOptionPane.showMessageDialog(null, "EMPATE!");
            limpar();
        }
        }
    
    

    public void limpar(){
        for (int i = 0; i < 9; i++) {
            botao[i].setText("");
            click[i] = false;
            botao[i].setBackground(new Color(80, 78, 78));
            
        }
    }
}
