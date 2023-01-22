package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelos.Dados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class App extends JFrame implements ActionListener {
    // Declarando componentes
    JButton bListarCanais, bCadastrarCanais;
    JButton bListarProgramas, bCadastrarProgramas;
    JButton bListarPessoas, bCadastrarPessoas;
    JLabel titulo;
    JPanel conteudo;
    Dados dados;

    App(Dados d) {
        dados = d;

        // Configurando janela
        this.setTitle("TeleGUIAdo");
        this.setLayout(null);
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Colocando titulo
        titulo = new JLabel("<html><pre>Tele\n  GUIA\n do</pre></html>");
        titulo.setBounds(0, 0, 200, 200);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));

        // Criando botoes de controle do app
        bListarCanais = new JButton("Listar Canais");
        bListarCanais.setBounds(220, 10, 100, 30);
        bListarCanais.addActionListener(this);

        bCadastrarCanais = new JButton("Cadastrar Canal");
        bCadastrarCanais.setBounds(220, 50, 100, 30);
        bCadastrarCanais.addActionListener(this);

        bListarProgramas = new JButton("Listar Programas");
        bListarProgramas.setBounds(320, 10, 100, 30);
        bListarProgramas.addActionListener(this);

        bCadastrarProgramas = new JButton("Cadastrar Programas");
        bCadastrarProgramas.setBounds(320, 50, 100, 30);
        bCadastrarProgramas.addActionListener(this);

        bListarPessoas = new JButton("Listar Pessoas");
        bListarPessoas.setBounds(420, 10, 100, 30);
        bListarPessoas.addActionListener(this);

        bCadastrarPessoas = new JButton("Cadastrar Pessoas");
        bCadastrarPessoas.setBounds(420, 50, 100, 30);
        bCadastrarPessoas.addActionListener(this);

        // Adicionando componentes na tela
        this.add(titulo);
        this.add(bListarCanais);
        this.add(bCadastrarCanais);
        this.add(bListarProgramas);
        this.add(bCadastrarProgramas);
        this.add(bListarPessoas);
        this.add(bCadastrarPessoas);
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
        // conteudo.setVisible(true);
        conteudo.updateUI();
        this.add(conteudo);
    }

    public static void main(String[] args) {
        Dados d = new Dados();
        new App(d);
    }

}
