package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;

/**
 * Classe que modela uma checkbox, com a identidade visual do projeto.
 */
public class CheckBoxCustomizada extends JCheckBox {
    /**
     * Constrói o checkbox e a customiza
     * 
     * @param tipo Tipo de icone que a checkbox terá. É uma string que pode ser "s",
     *             "t", "q" ou "d" qualquer coisa fora disso temos a checkbox sem
     *             letra
     * @param posX Posição que a checkbox ficará no eixo X
     * @param posY Posição que a checkbox ficará no eixo Y
     */
    public CheckBoxCustomizada(String tipo, int posX, int posY) {
        this.setFocusable(false);
        this.setBackground(new Color(50, 48, 48));
        this.setFocusable(false);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        this.setForeground(Color.white);
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.setIconTextGap(0);
        this.setMargin(new Insets(0, 0, 0, 0));

        switch (tipo) {
            case "s":
                this.setBounds(posX, posY, 25, 25);
                this.setIcon(new ImageIcon("assets/s_off.png"));
                this.setSelectedIcon(new ImageIcon("assets/s_on.png"));
                break;

            case "t":
                this.setBounds(posX, posY, 25, 25);
                this.setIcon(new ImageIcon("assets/t_off.png"));
                this.setSelectedIcon(new ImageIcon("assets/t_on.png"));
                break;

            case "q":
                this.setBounds(posX, posY, 25, 25);
                this.setIcon(new ImageIcon("assets/q_off.png"));
                this.setSelectedIcon(new ImageIcon("assets/q_on.png"));
                break;

            case "d":
                this.setBounds(posX, posY, 25, 25);
                this.setIcon(new ImageIcon("assets/d_off.png"));
                this.setSelectedIcon(new ImageIcon("assets/d_on.png"));
                break;

            case "f":
                this.setBounds(posX, posY, 25, 25);
                this.setIcon(new ImageIcon("assets/f_off.png"));
                this.setSelectedIcon(new ImageIcon("assets/f_on.png"));
                break;

            default:
                this.setText(tipo);
                this.setBounds(posX, posY, 25, 25);
                this.setIcon(new ImageIcon("assets/x_off.png"));
                this.setSelectedIcon(new ImageIcon("assets/x_on.png"));
                break;
        }
    }
}