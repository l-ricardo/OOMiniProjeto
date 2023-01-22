package view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.Canal;
import models.Dados;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostraCanal extends JPanel implements ListSelectionListener, ActionListener {
    Dados d;
    int indexCanalSelecionado;

    JList<Canal> listaCanais;
    JScrollPane listaCanaisRolavel;
    JButton visualizar, deletar;

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
        listaCanais.addListSelectionListener(this);

        listaCanaisRolavel = new JScrollPane(listaCanais);
        listaCanaisRolavel.setBounds(50, 50, 400, 500);

        visualizar = new JButton("Visualizar"); // TODO: Adicionar icone
        visualizar.setBounds(50, 550, 200, 30);
        visualizar.addActionListener(this);

        deletar = new JButton("Deletar"); // TODO: Adicionar icone
        deletar.setBounds(250, 550, 200, 30);
        deletar.addActionListener(this);

        add(listaCanaisRolavel);
        add(visualizar);
        add(deletar);

    }

    // Captura o canal da lista que foi selecionado e guarda seu index na variavel
    // indexCanalSelecionado para uso no botao visualizar
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Canal canalSelecionado = listaCanais.getSelectedValue();
            indexCanalSelecionado = d.getCanais().indexOf(canalSelecionado);
        }
    }

    // Quando clico no botao visualizar, cria um jdialog para exibir o cadastro do
    // canal selecionado e ou atualizar esse cadastro
    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();
        if (clicado == visualizar) {
            JDialog dialogoEdicao = new JDialog();
            CriaCanal painelEdicao = new CriaCanal(d, indexCanalSelecionado);
            dialogoEdicao.add(painelEdicao);
            dialogoEdicao.setVisible(true);
            dialogoEdicao.setSize(800, 600);
        }
        if (clicado == deletar) {
            d.getCanais().remove(indexCanalSelecionado);
            this.updateUI();
        }
    }
}