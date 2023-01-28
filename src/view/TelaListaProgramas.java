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

import model.Dados;
import model.Programa;

/**
 * Cria uma tela de conteúdo que estende de JPanel e faz uma listagem de programas
 * cadastrados.
 */
public class TelaListaProgramas extends JPanel implements ActionListener {
    Dados d;
    String programaSelecionado;

    ArrayList<BotaoRadialCustomizado> rbProgramas;
    BotaoPequeno visualizar, deletar;

    /**
     * Constroi um painel para listagem de dados da Classe Programa.
     * 
     * @param dados Base de dados
     */
    public TelaListaProgramas(Dados dados, String filtro) {
        this.d = dados;

        // Configurando painel
        this.setLayout(null);
        this.setBounds(0, 200, 1200, 600);
        this.setBackground(new Color(126, 121, 121));

        // -------------------------- Componentes programa ---------------------------
        JLabel dicaPrograma = new JLabel("Programas:");
        dicaPrograma.setBounds(450, 30, 300, 30);

        // Criando os botões radiais
        ButtonGroup grupoProgramas = new ButtonGroup();
        rbProgramas = new ArrayList<>();
        for (Programa programa : d.getTodosProgramas(filtro)) {
            BotaoRadialCustomizado rb = new BotaoRadialCustomizado(programa.getNome(), 0, 0);
            grupoProgramas.add(rb);
            rbProgramas.add(rb);
        }

        // Criando e adicionando os botões radiais à um painel
        JPanel listaProgramas = new JPanel();
        listaProgramas.setLayout(new BoxLayout(listaProgramas, BoxLayout.Y_AXIS));
        listaProgramas.setBackground(new Color(50, 48, 48));
        for (BotaoRadialCustomizado rb : rbProgramas) {
            listaProgramas.add(rb);
            rb.addActionListener(this);
        }

        // Criando e adicionando o painel com os botões radiais à um painel rolável
        JScrollPane listaProgramasRolavel = new JScrollPane(listaProgramas);
        listaProgramasRolavel.setBounds(450, 60, 300, 400);
        listaProgramasRolavel.setBorder(BorderFactory.createEtchedBorder());
        listaProgramasRolavel.setBackground(new Color(50, 48, 48));

        // --------------------------- Botão visualizar ----------------------------
        visualizar = new BotaoPequeno("Visualizar", 450, 460);
        visualizar.addActionListener(this);

        // ---------------------------- Botão deletar -----------------------------
        deletar = new BotaoPequeno("Deletar", 600, 460);
        deletar.addActionListener(this);
        // -------------------------------------------------------------------------

        // Adicionando componentes na tela
        this.add(dicaPrograma);
        this.add(listaProgramasRolavel);
        this.add(visualizar);
        this.add(deletar);
    }

    /**
     * 
     * Detecta quando os botões "visualizar" e "deletar" são clicados além de salvar
     * na variavel programaSelecionado o nome do botão radial clicado por último.
     * 
     * @param e O evento detectado pelo sistema
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();

        // Se o botão clicado for o visualizar, cria uma nova tela de edição passando
        // como parametro o banco de dados e o ultimo programa selecionado pelos botões
        // radiais.
        if (clicado == visualizar) {
            JDialog dialogoEdicao = new JDialog();
            TelaDetalhePrograma painelEdicao = new TelaDetalhePrograma(d, programaSelecionado);
            dialogoEdicao.add(painelEdicao);
            dialogoEdicao.setVisible(true);
            dialogoEdicao.setSize(1200, 600);
            dialogoEdicao.setLocationRelativeTo(null);
        }

        // Se o botão clicado for o deletar, chama o método deletarPrograma do banco de
        // dados d e atualiza a GUI
        if (clicado == deletar) {
            d.deletarPrograma(programaSelecionado);
            this.updateUI();
        }

        // Se o objeto clicado for um dos botões radiais, programaSelecionado recebe o
        // texto
        // do último botão radial slecionado
        if (rbProgramas.contains(clicado)) {
            programaSelecionado = e.getActionCommand();
        }
    }
}