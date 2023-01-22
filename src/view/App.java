package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Dados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class App extends JFrame implements ActionListener {
    // Declarando componentes
    JLabel titulo;
    JButton bListarCanais, bCadastrarCanais;
    JButton bListarProgramas, bCadastrarProgramas;
    JButton bListarPessoas, bCadastrarPessoas;
    JPanel conteudo;
    
    Dados dados;

    App(Dados d) {
        dados = d;

        // Configurando janela
        this.setTitle("TeleGUIAdo");
        this.setLayout(null);
        this.setSize(1200, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Colocando titulo
        titulo = new JLabel("<html><pre>Tele\n  GUIA\n do</pre></html>");
        titulo.setBounds(0, 0, 200, 200);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));

        // Criando botoes de controle do app
        bListarCanais = new JButton("Listar Canais");
        bListarCanais.setBounds(250, 50, 200, 50);
        bListarCanais.addActionListener(this);

        bCadastrarCanais = new JButton("Cadastrar Canal");
        bCadastrarCanais.setBounds(250, 100, 200, 50);
        bCadastrarCanais.addActionListener(this);

        bListarProgramas = new JButton("Listar Programas");
        bListarProgramas.setBounds(450, 50, 200, 50);
        bListarProgramas.addActionListener(this);

        bCadastrarProgramas = new JButton("Cadastrar Programas");
        bCadastrarProgramas.setBounds(450, 100, 200, 50);
        bCadastrarProgramas.addActionListener(this);

        bListarPessoas = new JButton("Listar Pessoas");
        bListarPessoas.setBounds(650, 50, 200, 50);
        bListarPessoas.addActionListener(this);

        bCadastrarPessoas = new JButton("Cadastrar Pessoas");
        bCadastrarPessoas.setBounds(650, 100, 200, 50);
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
