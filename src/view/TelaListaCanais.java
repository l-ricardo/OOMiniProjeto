package view;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Canal;
import model.Dados;

/**
 * Cria uma tela de conteúdo que estende de JPanel e faz uma listagem de canais
 * cadastrados.
 */
public class TelaListaCanais extends JPanel implements ActionListener {
    Dados d;
    String canalSelecionado;

    ArrayList<BotaoRadialCustomizado> rbCanais;
    BotaoPequeno visualizar, deletar;

    /**
     * Constroi um painel para listagem de dados da Classe Canal.
     * 
     * @param dados Base de dados
     */
    public TelaListaCanais(Dados dados, String filtro) {
        this.d = dados;

        // Configurando painel
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 600));
        this.setBackground(new Color(126, 121, 121));

        // -------------------------- Componentes canal ---------------------------
        JLabel dicaCanal = new JLabel("Canais:");
        dicaCanal.setBounds(50, 20, 300, 30);

        // Criando os botões radiais
        ButtonGroup grupoCanais = new ButtonGroup();
        rbCanais = new ArrayList<>();
        for (Canal canal : d.getCanais(filtro)) {
            BotaoRadialCustomizado rb = new BotaoRadialCustomizado(canal.getNome(), 0, 0);
            grupoCanais.add(rb);
            rbCanais.add(rb);
        }

        // Criando e adicionando os botões radiais à um painel
        JPanel listaCanais = new JPanel();
        listaCanais.setLayout(new BoxLayout(listaCanais, BoxLayout.Y_AXIS));
        listaCanais.setBackground(new Color(50, 48, 48));
        for (BotaoRadialCustomizado rb : rbCanais) {
            listaCanais.add(rb);
            rb.addActionListener(this);
        }

        // Criando e adicionando o painel com os botões radiais à um painel rolável
        JScrollPane listaCanaisRolavel = new JScrollPane(listaCanais);
        listaCanaisRolavel.setBounds(50, 50, 400, 450);
        listaCanaisRolavel.setBorder(BorderFactory.createEtchedBorder());
        listaCanaisRolavel.setBackground(new Color(50, 48, 48));

        // --------------------------- Botão visualizar ----------------------------
        visualizar = new BotaoPequeno("Visualizar", 50, 500);
        visualizar.addActionListener(this);

        // ---------------------------- Botão deletar -----------------------------
        deletar = new BotaoPequeno("Deletar", 250, 500);
        deletar.addActionListener(this);
        // -------------------------------------------------------------------------

        // Adicionando componentes na tela
        this.add(dicaCanal);
        this.add(listaCanaisRolavel);
        this.add(visualizar);
        this.add(deletar);
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