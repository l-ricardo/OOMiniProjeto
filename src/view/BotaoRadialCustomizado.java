package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

/**
 * Classe que cria um botão radial, com a identidade visual do projeto.
 */
public class BotaoRadialCustomizado extends JRadioButton {
    /**
     * Constrói o botão radial e o customiza.
     * 
     * @param texto Texto que será escrito no botão radial
     * @param posX  Posição que a botão radial ficará no eixo X
     * @param posY  Posição que a botão radial ficará no eixo Y
     */
    public BotaoRadialCustomizado(String texto, int posX, int posY) {
        this.setText(texto);
        this.setBounds(posX, posY, 25, 25);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        this.setBackground(new Color(50, 48, 48));
        this.setForeground(Color.white);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setFocusable(false);
        this.setIcon(new ImageIcon("assets/x_off.png"));
        this.setSelectedIcon(new ImageIcon("assets/x_on.png"));
    }
}