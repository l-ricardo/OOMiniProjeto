package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Dados;

/**
 * Cria a tela principal do app onde fica o menu e o conteiner que é modificado
 * com o conteudo das outras telas.
 */
public class App extends JFrame implements ActionListener {
    private Dados d;

    private JPanel conteudo = new JPanel();
    private BotaoGrande bListarCanais, bCadastrarCanais;
    private BotaoGrande bListarProgramas, bCadastrarProgramas;
    private BotaoGrande bListarPessoas, bCadastrarPessoas;
    private BotaoGrande limparFiltros;
    private CampoFiltragem filtroCanal, filtroPrograma, filtroPessoa;
    private CheckBoxCustomizada dom, seg, ter, qua, qui, sex, sab;

    /**
     * Constroi um painel para com o menu principal.
     * 
     * @param dados Base de dados
     */
    public App(Dados dados) {
        this.d = dados;

        // Configurando janela
        this.setTitle("TeleGUIAdo");
        this.setLayout(null);
        this.setSize(1200, 800);
        this.getContentPane().setBackground(new Color(50, 48, 48));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Criando um painel com o cabecalho
        JPanel cabecalho = new JPanel();
        cabecalho.setLayout(null);
        cabecalho.setBounds(0, 0, 1200, 200);
        cabecalho.setBackground(new Color(50, 48, 48));

        // -------------------------- Compontente titulo --------------------------
        JLabel titulo = new JLabel("<html><pre>Tele\n  GUIA\n do</pre></html>");
        titulo.setForeground(Color.white);
        titulo.setBounds(50, 0, 200, 200);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 50));

        // --------------------------- Componentes menu ---------------------------
        bListarCanais = new BotaoGrande("Listar Canais", 300, 50);
        bCadastrarCanais = new BotaoGrande("Cadastrar Canais", 300, 100);
        bListarProgramas = new BotaoGrande("Listar Programas", 500, 50);
        bCadastrarProgramas = new BotaoGrande("Cadastrar Programas", 500, 100);
        bListarPessoas = new BotaoGrande("Listar Pessoas", 700, 50);
        bCadastrarPessoas = new BotaoGrande("Cadastrar Pessoas", 700, 100);

        bListarCanais.addActionListener(this);
        bCadastrarCanais.addActionListener(this);
        bListarProgramas.addActionListener(this);
        bCadastrarProgramas.addActionListener(this);
        bListarPessoas.addActionListener(this);
        bCadastrarPessoas.addActionListener(this);

        // ------------------------- Componentes filtragem -------------------------
        JLabel dicaFiltragem = new JLabel("Filtros de listagem:");
        dicaFiltragem.setBounds(950, 20, 300, 30);
        dicaFiltragem.setForeground(Color.white);

        filtroCanal = new CampoFiltragem("Insira o nome do canal...", 950, 50);
        filtroPrograma = new CampoFiltragem("Insira o nome do programa...", 950, 75);
        filtroPessoa = new CampoFiltragem("Insira o nome da pessoa...", 950, 100);

        limparFiltros = new BotaoGrande("x", 1125, 25);
        limparFiltros.setSize(25, 25);
        limparFiltros.addActionListener(this);

        dom = new CheckBoxCustomizada("d", 952, 125);
        seg = new CheckBoxCustomizada("s", 980, 125);
        ter = new CheckBoxCustomizada("t", 1008, 125);
        qua = new CheckBoxCustomizada("q", 1036, 125);
        qui = new CheckBoxCustomizada("q", 1064, 125);
        sex = new CheckBoxCustomizada("s", 1092, 125);
        sab = new CheckBoxCustomizada("s", 1120, 125);
        // -------------------------------------------------------------------------

        // Adicionando componentes na tela
        cabecalho.add(filtroCanal);
        cabecalho.add(filtroPrograma);
        cabecalho.add(filtroPessoa);
        cabecalho.add(titulo);
        cabecalho.add(bListarCanais);
        cabecalho.add(bCadastrarCanais);
        cabecalho.add(bListarProgramas);
        cabecalho.add(bCadastrarProgramas);
        cabecalho.add(bListarPessoas);
        cabecalho.add(bCadastrarPessoas);
        cabecalho.add(dicaFiltragem);
        cabecalho.add(limparFiltros);
        cabecalho.add(dom);
        cabecalho.add(seg);
        cabecalho.add(ter);
        cabecalho.add(qua);
        cabecalho.add(qui);
        cabecalho.add(sex);
        cabecalho.add(sab);

        this.add(cabecalho);
        this.setVisible(true);
        this.requestFocusInWindow();
    }

    // --------------------------------- Listeners ---------------------------------
    /**
     * Muda o conteudo dependendo do botão clicado e também reage ao clique do botão
     * de limpar filtros.
     *
     * @param e O clique que desencadeou o evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();

        if (conteudo != null) {
            conteudo.setVisible(false);
        }

        if (clicado == bListarCanais) {
            if (!filtroCanal.isTextoInvalido()) {
                conteudo = new TelaListaCanais(d, filtroCanal.getText());
            } else {
                conteudo = new TelaListaCanais(d, null);
            }
        }

        if (clicado == bCadastrarCanais) {
            conteudo = new TelaDetalheCanal(d);
        }

        if (clicado == bListarProgramas) {
            if (!filtroCanal.isTextoInvalido() && getDiasSelecionados().size() != 0) {
                conteudo = new TelaListaProgramas(d, filtroCanal.getText(), getDiasSelecionados());
            } else if (!filtroPrograma.isTextoInvalido()) {
                conteudo = new TelaListaProgramas(d, filtroPrograma.getText());
            } else {
                conteudo = new TelaListaProgramas(d, null);
            }
        }

        if (clicado == bCadastrarProgramas) {
            conteudo = new TelaDetalhePrograma(d);
        }

        if (clicado == bListarPessoas) {
            if (!filtroPessoa.isTextoInvalido()) {
                conteudo = new TelaListaPessoas(d, filtroPessoa.getText());
            } else {
                conteudo = new TelaListaPessoas(d, null);
            }
        }

        if (clicado == bCadastrarPessoas) {
            conteudo = new TelaDetalhePessoa(d);
        }

        if (clicado == limparFiltros) {
            filtroCanal.setTextoPadrao();
            filtroPrograma.setTextoPadrao();
            filtroPessoa.setTextoPadrao();
            dom.setSelected(false);
            seg.setSelected(false);
            ter.setSelected(false);
            qua.setSelected(false);
            qui.setSelected(false);
            sex.setSelected(false);
            sab.setSelected(false);
            this.requestFocusInWindow();
        }

        this.add(conteudo, BorderLayout.SOUTH);
        conteudo.updateUI();
    }

    // ---------------------------- Metodos Auxiliares ----------------------------
    /**
     * Cria um array com os dias selecionados no filtro de dias.
     * 
     * @return Array de inteiros onde 1 representa domingo, 2 representa segunda,
     *         3 representa terça, etc...
     */
    private ArrayList<Integer> getDiasSelecionados() {
        ArrayList<Integer> dias = new ArrayList<Integer>();
        if (dom.isSelected()) {
            dias.add(1);
        }
        if (seg.isSelected()) {
            dias.add(2);
        }
        if (ter.isSelected()) {
            dias.add(3);
        }
        if (qua.isSelected()) {
            dias.add(4);
        }
        if (qui.isSelected()) {
            dias.add(5);
        }
        if (sex.isSelected()) {
            dias.add(6);
        }
        if (sab.isSelected()) {
            dias.add(7);
        }
        return dias;
    }

    // -----------------------------------------------------------------------------
    // ----------------------------------- MAIN -----------------------------------
    // -----------------------------------------------------------------------------
    public static void main(String[] args) {
        Dados d = new Dados();
        new App(d);
        // TODO: Criar UniTests
    }
    // -----------------------------------------------------------------------------
}