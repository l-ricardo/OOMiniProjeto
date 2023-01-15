package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import modelos.Canal;
import modelos.Dados;

public class TelaCanais extends JPanel {
    Dados d;

    TelaCanais(Dados dados) {
        d = dados;
        List<JButton> botoesCanais = new ArrayList<>();

        setBounds(0, 200, 800, 600);
        // setLayout(new GridLayout(8, d.getCanais().size()/8));
        setBackground(Color.ORANGE);

        for (Canal canal : d.getCanais()) {
            JButton botao = new JButton();
            botao.setText(canal.getNome() + " " + canal.getNumero());
            botao.setSize(100, 100);
            botoesCanais.add(botao);
        }

        for (JButton btt : botoesCanais) {
            add(btt); // TODO: DESCOBRIR PQ ESSE INFERNO NAO TA FUNCIONANDO E TA COLOCANDO TODOS OS BOTOES UM EM CIMA DO OUTRO
        }
    }
}