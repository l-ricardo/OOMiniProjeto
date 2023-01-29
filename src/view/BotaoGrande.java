package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Classe que cria um botão grande (muito usado no menu principal), com a
 * identidade visual do projeto.
 */
public class BotaoGrande extends JButton {
    /**
     * Constrói o botão e o customiza
     * 
     * @param texto Texto padrão que será escrito no botão
     * @param posX  Posição que o botão ficará no eixo X
     * @param posY  Posição que o botão ficará no eixo Y
     */
    public BotaoGrande(String texto, int posX, int posY) {
        this.setText(texto);
        this.setBounds(posX, posY, 200, 50);
        this.setFont(new Font("Comic Sans", Font.BOLD, 14));
        this.setBackground(new Color(126, 121, 121));
        this.setForeground(new Color(38, 38, 38));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setFocusable(false);
    }
}