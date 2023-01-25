package view;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import model.Canal;
import model.Dados;

public class TelaListaCanais extends JPanel implements ActionListener {
    Dados d;
    String canalSelecionado;

    ArrayList<JRadioButton> rbCanais;
    JButton visualizar, deletar;

    TelaListaCanais(Dados dados) {
        d = dados;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 600));
        this.setBackground(new Color(126, 121, 121));

        // -------------------------- Componentes canal---------------------------
        JLabel dicaCanal = new JLabel("Canais:");
        dicaCanal.setBounds(50, 20, 300, 30);

        ButtonGroup grupoCanais = new ButtonGroup();
        rbCanais = new ArrayList<>(); // Inicializa array de radiobutton

        JPanel listaCanais = new JPanel(); // Cria painel onde ficam as radiobutton
        listaCanais.setLayout(new BoxLayout(listaCanais, BoxLayout.Y_AXIS));
        listaCanais.setBackground(new Color(50, 48, 48));

        for (Canal canal : d.getCanais()) {
            JRadioButton rb = new JRadioButton(canal.getNome());
            rb.setFocusable(false);
            rb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            rb.setBackground(new Color(50, 48, 48));
            rb.setForeground(Color.white);
            grupoCanais.add(rb);
            rbCanais.add(rb);
        }
        for (JRadioButton rb : rbCanais) {
            listaCanais.add(rb);
            rb.addActionListener(this);
        }

        JScrollPane listaCanaisRolavel = new JScrollPane(listaCanais);
        listaCanaisRolavel.setBounds(50, 50, 400, 450);
        listaCanaisRolavel.setBorder(BorderFactory.createEtchedBorder());
        listaCanaisRolavel.setBackground(new Color(50, 48, 48));

        // --------------------------- Botão visualizar ----------------------------
        visualizar = new JButton("Visualizar"); // TODO: Adicionar icone
        visualizar.setBounds(50, 500, 200, 30);
        visualizar.setFocusable(false);
        visualizar.setBackground(new Color(50, 48, 48));
        visualizar.setForeground(Color.white);
        visualizar.setFont(new Font("Comic Sans", Font.BOLD, 10));
        visualizar.setBorder(BorderFactory.createEtchedBorder());
        visualizar.addActionListener(this);

        // ----------------------------- Botão deletar ------------------------------
        deletar = new JButton("Deletar"); // TODO: Adicionar icone
        deletar.setBounds(250, 500, 200, 30);
        deletar.setFocusable(false);
        deletar.setBackground(new Color(50, 48, 48));
        deletar.setForeground(Color.white);
        deletar.setFont(new Font("Comic Sans", Font.BOLD, 10));
        deletar.setBorder(BorderFactory.createEtchedBorder());
        deletar.addActionListener(this);

        add(dicaCanal);
        add(listaCanaisRolavel);
        add(visualizar);
        add(deletar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();
        if (clicado == visualizar) {
            JDialog dialogoEdicao = new JDialog();
            TelaDetalheCanal painelEdicao = new TelaDetalheCanal(d, canalSelecionado);
            dialogoEdicao.add(painelEdicao);
            dialogoEdicao.setVisible(true);
            dialogoEdicao.setSize(800, 600);
        }
        if (clicado == deletar) {
            d.deletarCanal(canalSelecionado);
            this.updateUI();
        }
        if (rbCanais.contains(clicado)) {
            // Atribui a canalSelecionado o texto do ultimo botao radial marcado
            canalSelecionado = e.getActionCommand(); 
        }
    }
}