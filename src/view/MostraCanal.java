package view;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import models.Canal;
import models.Dados;

import java.awt.Font;

public class MostraCanal extends JPanel {
    Dados d;
    JList<Canal> listaCanais;
    JScrollPane listaCanaisRolavel;

    MostraCanal(Dados dados) {
        d = dados;

        setLayout(null);
        setBounds(0, 200, 1186, 613);
        setOpaque(true);

        // Faz uma implentacao padrao de uma lista de elementos
        DefaultListModel<Canal> elementos = new DefaultListModel<>();

        for (Canal canal : d.getCanais()) {
            elementos.addElement(canal);
        }
        listaCanais = new JList<>(elementos);
        listaCanais.setVisible(true);
        listaCanais.setFont(new Font("Arial", Font.PLAIN, 18));

        listaCanaisRolavel = new JScrollPane(listaCanais);
        listaCanaisRolavel.setBounds(50, 50, 400, 500);

        add(listaCanaisRolavel);


    }
        // TODO: Adicionar aqui um contrutor de criar canais(dados,index) para mostrar o canal na tela CriaCanal
}