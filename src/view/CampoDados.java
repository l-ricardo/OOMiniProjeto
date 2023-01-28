package view;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 * Controi um campo de texto para a função de captura de dados com a identidade
 * visual do projeto.
 */
public class CampoDados extends JTextField implements FocusListener {
    String texto;

    /**
     * Constrói o campo de texto e o customiza
     * 
     * @param texto Texto padrão que será escrito no campo
     * @param posX  Posição que o campo de texto ficará no eixo X
     * @param posY  Posição que o campo de texto ficará no eixo Y
     */
    public CampoDados(String texto, int posX, int posY) {
        this.texto = texto;

        this.setText(texto);
        this.setBounds(posX, posY, 300, 30);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        this.setBackground(new Color(50, 48, 48));
        this.setForeground(Color.white);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setCaretColor(Color.white);
        this.addFocusListener(this);
    }

    /**
     * Checa se o texto digitado pelo usuario é valido, os casos invalidos são
     * quando o texto é o texto padrão do campo de texto e quando o campo está
     * vazio.
     * 
     * @return Retorna true se o texto for invalido, se valido retorna false
     */
    public boolean ehTextoInvalido() {
        return this.getText().equals(texto) || this.getText().isEmpty();
    }

    /**
     * Quando o usuário clicar no campo de texto e o campo estiver preenchido com o
     * texto padrão, o campo de texto será limpo.
     * 
     * @param e O clique que desencadeou o evento focusGained
     */
    @Override
    public void focusGained(FocusEvent e) {
        Object focado = e.getSource();

        if (focado == this && this.getText().equals(texto)) {
            this.setText("");
        }
    }

    /**
     * Se o campo de texto estiver vazio e o usuário perder o foco do campo,
     * ele será preenchido como o texto padrão
     *
     * @param e O clique que desencadeou o evento focusLost
     */
    @Override
    public void focusLost(FocusEvent e) {
        Object focado = e.getSource();

        if (focado == this && this.getText().isEmpty()) {
            this.setText(texto);
        }
    }
}