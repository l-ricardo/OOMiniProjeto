package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Dados;

/**
 * Cria a tela principal do app onde fica o menu e o conteiner que é modificado
 * com o conteudo das outras telas.
 */
public class App extends JFrame implements ActionListener {
    Dados d;

    JPanel conteudo = new JPanel();
    BotaoGrande bListarCanais, bCadastrarCanais;
    BotaoGrande bListarProgramas, bCadastrarProgramas;
    BotaoGrande bListarPessoas, bCadastrarPessoas;
    BotaoGrande limparFiltros;
    CampoFiltragem filtroCanal, filtroPrograma, filtroPessoa;
    CheckBoxCustomizada dom, seg, ter, qua, qui, sex, sab;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();

        if (conteudo != null) {
            conteudo.setVisible(false);
        }

        if (clicado == bListarCanais) {
            if (!filtroCanal.getText().contains("Insira o nome do canal...")) {
                conteudo = new TelaListaCanais(d, filtroCanal.getText());
            } else {
                conteudo = new TelaListaCanais(d, null);
            }
        }

        if (clicado == bCadastrarCanais) {
            conteudo = new TelaDetalheCanal(d);
        }

        if (clicado == bListarProgramas) {
            if (!filtroPrograma.getText().contains("Insira o nome do programa...")) {
                conteudo = new TelaListaProgramas(d, filtroPrograma.getText());
            } else {
                conteudo = new TelaListaProgramas(d, null);
            }
        }

        if (clicado == bCadastrarProgramas) {
            conteudo = new TelaDetalhePrograma(d);
        }

        // if (clicado == bListarPessoas) {
        //     if (!filtroPessoa.getText().contains("Insira o nome da pessoa...")) {
        //         conteudo = new TelaListaPessoas(d, filtroPessoa.getText());
        //     } else {
        //         conteudo = new TelaListaPessoas(d, null);
        //     }
        // }

        // if (clicado == bCadastrarPessoas) {
        //     conteudo = new TelaDetalhePessoa(d);
        // }

        if (clicado == limparFiltros) {
            filtroCanal.setText("Insira o nome do canal...");
            filtroPrograma.setText("Insira o nome do programa...");
            filtroPessoa.setText("Insira o nome da pessoa...");
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

    public static void main(String[] args) {
        Dados d = new Dados();
        new App(d);
        // TODO: Atualizar diagramas de classes e pacotes (Herança abstrata pontilhado)
        // TODO: Criar UniTests
        // TODO: Otimizar todos os Override se actionPerformed
    }
}
