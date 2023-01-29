package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * Classe que modela um botão pequeno (muito usado nos submenus para funções
 * como editar, atualizar, visualizar), com a identidade visual do projeto.
 */
public class BotaoPequeno extends JButton {
    /**
     * Constrói o botão e o customiza
     * 
     * @param texto Texto padrão que será escrito no botão
     * @param posX  Posição que o botão ficará no eixo X
     * @param posY  Posição que o botão ficará no eixo Y
     */
    public BotaoPequeno(String texto, int posX, int posY) {
        this.setText(texto);
        this.setBounds(posX, posY, 150, 30);
        this.setFont(new Font("Comic Sans", Font.BOLD, 14));
        this.setBackground(new Color(50, 48, 48));
        this.setForeground(Color.white);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setFocusable(false);
    }
}