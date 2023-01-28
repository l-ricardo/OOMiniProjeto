package view;

import java.util.ArrayList;

import java.awt.Color;
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
        this.setBounds(0, 200, 1200, 600);
        this.setBackground(new Color(126, 121, 121));

        // -------------------------- Componentes canal ---------------------------
        JLabel dicaCanal = new JLabel("Canais:");
        dicaCanal.setBounds(450, 30, 300, 30);

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
        listaCanaisRolavel.setBounds(450, 60, 300, 400);
        listaCanaisRolavel.setBorder(BorderFactory.createEtchedBorder());
        listaCanaisRolavel.setBackground(new Color(50, 48, 48));

        // --------------------------- Botão visualizar ----------------------------
        visualizar = new BotaoPequeno("Visualizar", 450, 460);
        visualizar.addActionListener(this);

        // ---------------------------- Botão deletar -----------------------------
        deletar = new BotaoPequeno("Deletar", 600, 460);
        deletar.addActionListener(this);
        // -------------------------------------------------------------------------

        // Adicionando componentes na tela
        this.add(dicaCanal);
        this.add(listaCanaisRolavel);
        this.add(visualizar);
        this.add(deletar);
    }

    /**
     * 
     * Detecta quando os botões "visualizar" e "deletar" são clicados além de salvar
     * na variavel canalSelecionado o nome do botão radial clicado por último.
     * 
     * @param e O evento detectado pelo sistema
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();

        // Se o botão clicado for o visualizar, cria uma nova tela de edição passando
        // como parametro o banco de dados e o ultimo canal selecionado pelos botões
        // radiais.
        if (clicado == visualizar) {
            JDialog dialogoEdicao = new JDialog();
            TelaDetalheCanal painelEdicao = new TelaDetalheCanal(d, canalSelecionado);
            dialogoEdicao.add(painelEdicao);
            dialogoEdicao.setVisible(true);
            dialogoEdicao.setSize(850, 600);
            dialogoEdicao.setLocationRelativeTo(null);

        }

        // Se o botão clicado for o deletar, chama o método deletarCanal do banco de
        // dados d e atualiza a GUI
        if (clicado == deletar) {
            d.deletarCanal(canalSelecionado);
            this.updateUI();
        }

        // Se o objeto clicado for um dos botões radiais, canalSelecionado recebe o
        // texto
        // do último botão radial slecionado
        if (rbCanais.contains(clicado)) {
            canalSelecionado = e.getActionCommand();
        }
    }
}