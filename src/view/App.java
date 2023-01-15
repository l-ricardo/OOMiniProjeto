package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.Canal;
import modelos.Dados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class App extends JFrame implements ActionListener {
    // Declarando componentes
    JFrame tela;
    JButton bCanais, bCadastrarCanais;
    JButton bProgramas, bCadastrarProgramas;
    JButton bPessoas, bCadastrarPessoas;
    JLabel titulo;
    JPanel conteudo;
    JPanel telaCanais, telaCadastrarCanais;
    JPanel telaProgramas, telaCadastrarProgramas;
    JPanel telaPessoas, telaCadastrarPessoas;
    Dados dados;

    App(Dados d) {
        dados = d;
        // Criando janela
        tela = new JFrame("TeleGUIAdo");
        tela.setLayout(null);
        tela.setSize(800, 800);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Colocando titulo
        titulo = new JLabel("<html><pre>Tele\n  GUIA\n do</pre></html>");
        titulo.setBounds(0, 0, 200, 200);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));

        // Criando botoes de controle do app
        bCanais = new JButton("bCanais");
        bCanais.setBounds(220, 10, 100, 30);
        bCanais.addActionListener(this);

        bCadastrarCanais = new JButton("bCadastrarCanais");
        bCadastrarCanais.setBounds(220, 50, 100, 30);
        bCadastrarCanais.addActionListener(this);

        bProgramas = new JButton("bProgramas");
        bProgramas.setBounds(320, 10, 100, 30);
        bProgramas.addActionListener(this);

        bCadastrarProgramas = new JButton("bCadastrarProgramas");
        bCadastrarProgramas.setBounds(320, 50, 100, 30);
        bCadastrarProgramas.addActionListener(this);

        bPessoas = new JButton("bPessoas");
        bPessoas.setBounds(420, 10, 100, 30);
        bPessoas.addActionListener(this);

        bCadastrarPessoas = new JButton("bCadastrarPessoas");
        bCadastrarPessoas.setBounds(420, 50, 100, 30);
        bCadastrarPessoas.addActionListener(this);

        // Criando painel dinamico
        telaCanais = new JPanel();
        telaCanais.setBounds(0, 200, 800, 600);
        telaCanais.setLayout(new FlowLayout());
        for (Canal canal : getDados().getCanais()) {
            JButton botaoCanal = new JButton(canal.getNome() + " " + canal.getNumero());
            // botaoCanal.setBounds(50, 10, 300, 30);
            telaCanais.add(botaoCanal);
        }

        telaCadastrarCanais = new JPanel();
        telaCadastrarCanais.setBounds(0, 200, 800, 600);
        // telaCadastrarCanais.setLayout(new FlowLayout());
        JLabel mensagemTelaCadastrarCanais = new JLabel("Voce esta no painel telaCadastrarCanais");
        mensagemTelaCadastrarCanais.setBounds(50, 10, 800, 30);
        mensagemTelaCadastrarCanais.setFont(new Font("Arial", Font.BOLD, 25));
        telaCadastrarCanais.add(mensagemTelaCadastrarCanais);

        telaProgramas = new JPanel();
        telaProgramas.setBounds(0, 200, 800, 600);
        // telaProgramas.setLayout(new FlowLayout());
        JLabel mensagemTelaProgramas = new JLabel("Voce esta no painel telaProgramas");
        mensagemTelaProgramas.setBounds(50, 10, 800, 30);
        mensagemTelaProgramas.setFont(new Font("Arial", Font.BOLD, 25));
        telaProgramas.add(mensagemTelaProgramas);

        telaCadastrarProgramas = new JPanel();
        telaCadastrarProgramas.setBounds(0, 200, 800, 600);
        // telaCadastrarProgramas.setLayout(new FlowLayout());
        JLabel mensagemTelaCadastrarProgramas = new JLabel("Voce esta no painel telaCadastrarProgramas");
        mensagemTelaCadastrarProgramas.setBounds(50, 10, 800, 30);
        mensagemTelaCadastrarProgramas.setFont(new Font("Arial", Font.BOLD, 25));
        telaCadastrarProgramas.add(mensagemTelaCadastrarProgramas);

        telaPessoas = new JPanel();
        telaPessoas.setBounds(0, 200, 800, 600);
        // telaPessoas.setLayout(new FlowLayout());
        JLabel mensagemTelaPessoas = new JLabel("Voce esta no painel telaPessoas");
        mensagemTelaPessoas.setBounds(50, 10, 800, 30);
        mensagemTelaPessoas.setFont(new Font("Arial", Font.BOLD, 25));
        telaPessoas.add(mensagemTelaPessoas);

        telaCadastrarPessoas = new JPanel();
        telaCadastrarPessoas.setBounds(0, 200, 800, 600);
        // telaCadastrarPessoas.setLayout(new FlowLayout());
        JLabel mensagemTelaCadastrarPessoas = new JLabel("Voce esta no painel telaCadastrarPessoas");
        mensagemTelaCadastrarPessoas.setBounds(50, 10, 800, 30);
        mensagemTelaCadastrarPessoas.setFont(new Font("Arial", Font.BOLD, 25));
        telaCadastrarPessoas.add(mensagemTelaCadastrarPessoas);

        if (conteudo == null) {
            conteudo = telaCanais;
        }

        ////////////////////////////////////////////////////////////////////
        titulo.setBackground(Color.BLUE);
        titulo.setOpaque(true);
        
        conteudo.setBackground(Color.YELLOW);
        conteudo.setOpaque(true);
        ////////////////////////////////////////////////////////////////////

        // Adicionando componentes na tela
        tela.add(titulo);
        tela.add(bCanais);
        tela.add(bCadastrarCanais);
        tela.add(bProgramas);
        tela.add(bCadastrarProgramas);
        tela.add(bPessoas);
        tela.add(bCadastrarPessoas);
        tela.add(conteudo);
        tela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();
        tela.remove(conteudo);
        if (clicado == bCanais) {
            // conteudo = telaCanais;
            conteudo = new TelaCanais(dados);
        }
        if (clicado == bCadastrarCanais) {
            conteudo = new CriaCanal(dados);
        }
        if (clicado == bProgramas) {
            conteudo = telaProgramas;
        }
        if (clicado == bCadastrarProgramas) {
            conteudo = telaCadastrarProgramas;
        }
        if (clicado == bPessoas) {
            conteudo = telaPessoas;
        }
        if (clicado == bCadastrarPessoas) {
            conteudo = telaCadastrarPessoas;
        }
        tela.add(conteudo);
        tela.repaint();
    }

    public Dados getDados() {
        return dados;
    }

    public static void main(String[] args) {
        Dados d = new Dados();
        new App(d);
    }

}
