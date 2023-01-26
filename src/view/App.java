package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Dados;

/**
 * Cria a tela principal do app onde fica o menu e o conteiner que é modificado
 * com o conteudo das outras telas.
 */
public class App extends JFrame implements ActionListener, FocusListener {
    Dados dados;

    JButton bListarCanais, bCadastrarCanais;
    JButton bListarProgramas, bCadastrarProgramas;
    JButton bListarPessoas, bCadastrarPessoas;
    JButton limparFiltros;
    JPanel conteudo = new JPanel();
    JTextField filtroCanal, filtroPrograma, filtroPessoa;

    /**
     * Constroi um painel para com o menu principal.
     * 
     * @param d Base de dados
     */
    App(Dados d) {
        dados = d;

        // Configurando janela
        this.setTitle("TeleGUIAdo");
        this.setLayout(new BorderLayout());
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(50, 48, 48));

        JPanel cabecalho = new JPanel();
        cabecalho.setPreferredSize(new Dimension(1200, 200));
        cabecalho.setLayout(null);
        cabecalho.setBackground(new Color(50, 48, 48));

        // Colocando titulo
        JLabel titulo = new JLabel("<html><pre>Tele\n  GUIA\n do</pre></html>");
        titulo.setForeground(Color.white);
        titulo.setBounds(50, 0, 200, 200);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 50));

        // ------------------------- Componentes controle -------------------------
        bListarCanais = new JButton("Listar Canais");
        bListarCanais.setBounds(300, 50, 200, 50);
        bListarCanais.setFocusable(false);
        bListarCanais.setBackground(new Color(126, 121, 121));
        bListarCanais.setForeground(new Color(38, 38, 38));
        bListarCanais.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bListarCanais.setBorder(BorderFactory.createEtchedBorder());
        bListarCanais.addActionListener(this);

        bCadastrarCanais = new JButton("Cadastrar Canal");
        bCadastrarCanais.setBounds(300, 100, 200, 50);
        bCadastrarCanais.setFocusable(false);
        bCadastrarCanais.setBackground(new Color(126, 121, 121));
        bCadastrarCanais.setForeground(new Color(38, 38, 38));
        bCadastrarCanais.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bCadastrarCanais.setBorder(BorderFactory.createEtchedBorder());
        bCadastrarCanais.addActionListener(this);

        bListarProgramas = new JButton("Listar Programas");
        bListarProgramas.setBounds(500, 50, 200, 50);
        bListarProgramas.setFocusable(false);
        bListarProgramas.setBackground(new Color(126, 121, 121));
        bListarProgramas.setForeground(new Color(38, 38, 38));
        bListarProgramas.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bListarProgramas.setBorder(BorderFactory.createEtchedBorder());
        bListarProgramas.addActionListener(this);

        bCadastrarProgramas = new JButton("Cadastrar Programas");
        bCadastrarProgramas.setBounds(500, 100, 200, 50);
        bCadastrarProgramas.setFocusable(false);
        bCadastrarProgramas.setBackground(new Color(126, 121, 121));
        bCadastrarProgramas.setForeground(new Color(38, 38, 38));
        bCadastrarProgramas.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bCadastrarProgramas.setBorder(BorderFactory.createEtchedBorder());
        bCadastrarProgramas.addActionListener(this);

        bListarPessoas = new JButton("Listar Pessoas");
        bListarPessoas.setBounds(700, 50, 200, 50);
        bListarPessoas.setFocusable(false);
        bListarPessoas.setBackground(new Color(126, 121, 121));
        bListarPessoas.setForeground(new Color(38, 38, 38));
        bListarPessoas.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bListarPessoas.setBorder(BorderFactory.createEtchedBorder());
        bListarPessoas.addActionListener(this);

        bCadastrarPessoas = new JButton("Cadastrar Pessoas");
        bCadastrarPessoas.setBounds(700, 100, 200, 50);
        bCadastrarPessoas.setFocusable(false);
        bCadastrarPessoas.setBackground(new Color(126, 121, 121));
        bCadastrarPessoas.setForeground(new Color(38, 38, 38));
        bCadastrarPessoas.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bCadastrarPessoas.setBorder(BorderFactory.createEtchedBorder());
        bCadastrarPessoas.addActionListener(this);

        // ------------------------- Componentes filtragem -------------------------
        JLabel dicaFiltragem = new JLabel("Filtros de listagem:");
        dicaFiltragem.setBounds(950, 20, 300, 30);
        dicaFiltragem.setForeground(Color.white);

        filtroCanal = new JTextField("Insira o nome do canal...");
        filtroCanal.setBounds(950, 50, 200, 25);
        filtroCanal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filtroCanal.setBackground(new Color(126, 121, 121));
        filtroCanal.setBorder(BorderFactory.createEtchedBorder());
        filtroCanal.setForeground(new Color(38, 38, 38));
        filtroCanal.setCaretColor(Color.white);
        filtroCanal.addFocusListener(this);

        filtroPrograma = new JTextField("Insira o nome do programa...");
        filtroPrograma.setBounds(950, 75, 200, 25);
        filtroPrograma.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filtroPrograma.setBackground(new Color(126, 121, 121));
        filtroPrograma.setBorder(BorderFactory.createEtchedBorder());
        filtroPrograma.setForeground(new Color(38, 38, 38));
        filtroPrograma.setCaretColor(Color.white);
        filtroPrograma.addFocusListener(this);

        filtroPessoa = new JTextField("Insira o nome da pessoa...");
        filtroPessoa.setBounds(950, 100, 200, 25);
        filtroPessoa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filtroPessoa.setBackground(new Color(126, 121, 121));
        filtroPessoa.setBorder(BorderFactory.createEtchedBorder());
        filtroPessoa.setForeground(new Color(38, 38, 38));
        filtroPessoa.setCaretColor(Color.white);
        filtroPessoa.addFocusListener(this);

        limparFiltros = new JButton("x");
        limparFiltros.setBounds(1125, 25, 25, 25);
        limparFiltros.setFocusable(false);
        limparFiltros.setBackground(new Color(126, 121, 121));
        limparFiltros.setForeground(new Color(38, 38, 38));
        limparFiltros.setFont(new Font("Comic Sans", Font.BOLD, 20));
        limparFiltros.setBorder(BorderFactory.createEtchedBorder());
        limparFiltros.addActionListener(this);

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

        this.add(cabecalho, BorderLayout.NORTH);
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
            conteudo = new TelaListaCanais(dados);
        }
        if (clicado == bCadastrarCanais) {
            conteudo = new TelaDetalheCanal(dados);
        }
        if (clicado == bListarProgramas) {
            // conteudo = new contWIP(dados);
        }
        if (clicado == limparFiltros) {
            filtroCanal.setText("Insira o nome do canal...");
            filtroPrograma.setText("Insira o nome do programa...");
            filtroPessoa.setText("Insira o nome da pessoa...");
            this.requestFocusInWindow();
        }

        this.add(conteudo, BorderLayout.CENTER);
        conteudo.updateUI();
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object focado = e.getSource();

        if (focado == filtroCanal
                && filtroCanal.getText().equals("Insira o nome do canal...")) {
            filtroCanal.setText("");
        }
        if (focado == filtroPrograma
                && filtroPrograma.getText().equals("Insira o nome do programa...")) {
            filtroPrograma.setText("");
        }
        if (focado == filtroPessoa
                && filtroPessoa.getText().equals("Insira o nome da pessoa...")) {
            filtroPessoa.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object focado = e.getSource();

        if (focado == filtroCanal && filtroCanal.getText().isEmpty()) {
            filtroCanal.setText("Insira o nome do canal...");
        }
        if (focado == filtroPrograma && filtroPrograma.getText().isEmpty()) {
            filtroPrograma.setText("Insira o nome do programa...");
        }
        if (focado == filtroPessoa && filtroPessoa.getText().isEmpty()) {
            filtroPessoa.setText("Insira o nome da pessoa...");
        }
    }

    public static void main(String[] args) {
        Dados d = new Dados();
        new App(d);
        // TODO: Atualizar diagramas de classes e pacotes (Herança abstrata pontilhado)
        // TODO: Criar UniTests
    }
}
