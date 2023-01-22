package view;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.*;

import modelos.Canal;
import modelos.Dados;

public class MostraCanal extends JPanel {
    Dados d;
    JList<Canal> listaCanais;
    JScrollPane listaCanaisRolavel;

    MostraCanal(Dados dados) {
        d = dados;
        
        setLayout(null);
        setBackground(Color.PINK);
        setBounds(0, 200, 1300, 600);
        setOpaque(true);

        // Faz uma implentacao padrao de uma lista de elementos
        DefaultListModel<Canal> elementos = new DefaultListModel<>();

        for (Canal canal : d.getCanais()) {
            elementos.addElement(canal);
        }
        listaCanais = new JList<>(elementos);
        listaCanais.setVisible(true);

        listaCanaisRolavel = new JScrollPane(listaCanais);
        listaCanaisRolavel.setBounds(0, 200, 650, 300);

        add(listaCanaisRolavel);

    }
}