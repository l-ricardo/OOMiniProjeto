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
import model.Pessoa;

/**
 * Cria uma tela de conteúdo que estende de JPanel e faz uma listagem de pessoas
 * cadastradas.
 */
public class TelaListaPessoas extends JPanel implements ActionListener {
    Dados d;
    String pessoaSelecionada;

    ArrayList<BotaoRadialCustomizado> rbPessoas;
    BotaoPequeno visualizar, deletar;

    /**
     * Constroi um painel para listagem de dados da Classe Pessoa.
     * 
     * @param dados  Base de dados
     * @param filtro Filtro de pessoas que devem aparecer na listagem, se null
     *               lista todos.
     */
    public TelaListaPessoas(Dados dados, String filtro) {
        this.d = dados;

        // Configurando painel
        this.setLayout(null);
        this.setBounds(0, 200, 1200, 600);
        this.setBackground(new Color(126, 121, 121));

        // -------------------------- Componentes pessoa ---------------------------
        JLabel dicaPessoa = new JLabel("Pessoas:");
        dicaPessoa.setBounds(450, 30, 300, 30);

        // Criando os botões radiais
        ButtonGroup grupoPessoas = new ButtonGroup();
        rbPessoas = new ArrayList<>();
        for (Pessoa pessoa : d.getTodasPessoas(filtro)) {
            BotaoRadialCustomizado rb = new BotaoRadialCustomizado(pessoa.getNome(), 0, 0);
            grupoPessoas.add(rb);
            rbPessoas.add(rb);
        }

        // Criando e adicionando os botões radiais à um painel
        JPanel listaPessoas = new JPanel();
        listaPessoas.setLayout(new BoxLayout(listaPessoas, BoxLayout.Y_AXIS));
        listaPessoas.setBackground(new Color(50, 48, 48));
        for (BotaoRadialCustomizado rb : rbPessoas) {
            listaPessoas.add(rb);
            rb.addActionListener(this);
        }

        // Criando e adicionando o painel com os botões radiais à um painel rolável
        JScrollPane listaPessoasRolavel = new JScrollPane(listaPessoas);
        listaPessoasRolavel.setBounds(450, 60, 300, 400);
        listaPessoasRolavel.setBorder(BorderFactory.createEtchedBorder());
        listaPessoasRolavel.setBackground(new Color(50, 48, 48));

        // --------------------------- Botão visualizar ----------------------------
        visualizar = new BotaoPequeno("Visualizar", 450, 460);
        visualizar.addActionListener(this);

        // ---------------------------- Botão deletar -----------------------------
        deletar = new BotaoPequeno("Deletar", 600, 460);
        deletar.addActionListener(this);
        // -------------------------------------------------------------------------

        // Adicionando componentes na tela
        this.add(dicaPessoa);
        this.add(listaPessoasRolavel);
        this.add(visualizar);
        this.add(deletar);
    }

    // --------------------------------- Listeners ---------------------------------
    /**
     * 
     * Detecta quando os botões "visualizar" e "deletar" são clicados além de salvar
     * na variavel pessoaSelecionada o nome do botão radial clicado por último.
     * 
     * @param e O evento detectado pelo sistema
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();

        // Se o botão clicado for o visualizar, cria uma nova tela de edição passando
        // como parametro o banco de dados e a ultima pessoa selecionada pelos botões
        // radiais.
        if (clicado == visualizar) {
            JDialog dialogoEdicao = new JDialog();
            TelaDetalhePessoa painelEdicao = new TelaDetalhePessoa(d, pessoaSelecionada);
            dialogoEdicao.add(painelEdicao);
            dialogoEdicao.setVisible(true);
            dialogoEdicao.setSize(1200, 600);
            dialogoEdicao.setLocationRelativeTo(null);
        }

        // Se o botão clicado for o deletar, chama o método deletarPessoa do banco de
        // dados d e atualiza a GUI
        if (clicado == deletar) {
            d.deletarPessoa(pessoaSelecionada);
            this.updateUI();
        }

        // Se o objeto clicado for um dos botões radiais, pessoaSelecionada recebe o
        // texto
        // do último botão radial slecionado
        if (rbPessoas.contains(clicado)) {
            pessoaSelecionada = e.getActionCommand();
        }
    }
}