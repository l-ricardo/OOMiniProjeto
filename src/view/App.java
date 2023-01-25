package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Dados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class App extends JFrame implements ActionListener {
    Dados dados;

    // Declarando componentes
    JLabel titulo;
    JButton bListarCanais, bCadastrarCanais;
    JButton bListarProgramas, bCadastrarProgramas;
    JButton bListarPessoas, bCadastrarPessoas;
    JPanel conteudo= new JPanel();
    JPanel cabecalho = new JPanel();

    App(Dados d) {
        dados = d;

        // Configurando janela
        this.setTitle("TeleGUIAdo");
        this.setLayout(new BorderLayout());
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(50, 48, 48));

        cabecalho.setPreferredSize(new Dimension(1200, 200));
        cabecalho.setLayout(null);
        cabecalho.setBackground(new Color(50, 48, 48));

        // Colocando titulo
        titulo = new JLabel("<html><pre>Tele\n  GUIA\n do</pre></html>");
        titulo.setForeground(Color.white);
        titulo.setBounds(0, 0, 200, 200);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));

        // Criando botoes de controle do app
        bListarCanais = new JButton("Listar Canais");
        bListarCanais.setBounds(250, 50, 200, 50);
        bListarCanais.setFocusable(false);
        bListarCanais.setBackground(new Color(126, 121, 121));
        bListarCanais.setForeground(new Color(38, 38, 38));
        bListarCanais.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bListarCanais.setBorder(BorderFactory.createEtchedBorder());
        bListarCanais.addActionListener(this);

        bCadastrarCanais = new JButton("Cadastrar Canal");
        bCadastrarCanais.setBounds(250, 100, 200, 50);
        bCadastrarCanais.setFocusable(false);
        bCadastrarCanais.setBackground(new Color(126, 121, 121));
        bCadastrarCanais.setForeground(new Color(38, 38, 38));
        bCadastrarCanais.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bCadastrarCanais.setBorder(BorderFactory.createEtchedBorder());
        bCadastrarCanais.addActionListener(this);

        bListarProgramas = new JButton("Listar Programas");
        bListarProgramas.setBounds(450, 50, 200, 50);
        bListarProgramas.setFocusable(false);
        bListarProgramas.setBackground(new Color(126, 121, 121));
        bListarProgramas.setForeground(new Color(38, 38, 38));
        bListarProgramas.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bListarProgramas.setBorder(BorderFactory.createEtchedBorder());
        bListarProgramas.addActionListener(this);

        bCadastrarProgramas = new JButton("Cadastrar Programas");
        bCadastrarProgramas.setBounds(450, 100, 200, 50);
        bCadastrarProgramas.setFocusable(false);
        bCadastrarProgramas.setBackground(new Color(126, 121, 121));
        bCadastrarProgramas.setForeground(new Color(38, 38, 38));
        bCadastrarProgramas.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bCadastrarProgramas.setBorder(BorderFactory.createEtchedBorder());
        bCadastrarProgramas.addActionListener(this);

        bListarPessoas = new JButton("Listar Pessoas");
        bListarPessoas.setBounds(650, 50, 200, 50);
        bListarPessoas.setFocusable(false);
        bListarPessoas.setBackground(new Color(126, 121, 121));
        bListarPessoas.setForeground(new Color(38, 38, 38));
        bListarPessoas.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bListarPessoas.setBorder(BorderFactory.createEtchedBorder());
        bListarPessoas.addActionListener(this);

        bCadastrarPessoas = new JButton("Cadastrar Pessoas");
        bCadastrarPessoas.setBounds(650, 100, 200, 50);
        bCadastrarPessoas.setFocusable(false);
        bCadastrarPessoas.setBackground(new Color(126, 121, 121));
        bCadastrarPessoas.setForeground(new Color(38, 38, 38));
        bCadastrarPessoas.setFont(new Font("Comic Sans", Font.BOLD, 14));
        bCadastrarPessoas.setBorder(BorderFactory.createEtchedBorder());
        bCadastrarPessoas.addActionListener(this);

        // Adicionando componentes na tela
        cabecalho.add(titulo);
        cabecalho.add(bListarCanais);
        cabecalho.add(bCadastrarCanais);
        cabecalho.add(bListarProgramas);
        cabecalho.add(bCadastrarProgramas);
        cabecalho.add(bListarPessoas);
        cabecalho.add(bCadastrarPessoas);

        this.add(cabecalho, BorderLayout.NORTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();
        if (conteudo != null) {
            conteudo.setVisible(false);
        }
        if (clicado == bListarCanais) {
            conteudo = new MostraCanal(dados);
        }
        if (clicado == bCadastrarCanais) {
            conteudo = new CriaCanal(dados);
        }
        if (clicado == bListarProgramas) {
            conteudo = new contWIP(dados);
        }

        this.add(conteudo, BorderLayout.CENTER);
        conteudo.updateUI();

    }

    public static void main(String[] args) {
        Dados d = new Dados();
        new App(d);
        // TODO: Atualizar os diagramas de classes e pacotes (Herança abstrata
        // pontilhado)
        // TODO: Criar UniTests
    }

}
