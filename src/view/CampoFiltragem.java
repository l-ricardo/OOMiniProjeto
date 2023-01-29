package view;

import java.awt.Color;

/**
 * Classe que modela um campo de texto para a função de filtragem com a
 * identidade visual do projeto.
 */
public class CampoFiltragem extends CampoDados {

    /**
     * Constrói o campo de texto e o customiza
     * 
     * @param texto Texto padrão que será escrito no campo
     * @param posX  Posição que o campo de texto ficará no eixo X
     * @param posY  Posição que o campo de texto ficará no eixo Y
     */
    public CampoFiltragem(String texto, int posX, int posY) {
        super(texto, posX, posY);

        this.setSize( 200, 25);
        this.setBackground(new Color(126, 121, 121));
        this.setForeground(new Color(38, 38, 38));
    }
}