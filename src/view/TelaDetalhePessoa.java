package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Dados;

/**
 * Cria uma tela de conteúdo que estende de JPanel, com as funcionalidades de
 * criação e edição de pessoas.
 */
public class TelaDetalhePessoa extends JPanel {
    Dados d;

    /**
     * Constroi um painel para cadastro de dados da Classe pessoa.
     * 
     * @param dados Base de dados
     */
    public TelaDetalhePessoa(Dados dados) {
        this.d = dados;

        // Configurando painel
        this.setLayout(null);
        this.setBounds(0, 200, 1200, 600);
        this.setBackground(new Color(126, 121, 121));

        // Mensagem WIP
        JLabel mensagemTelaCadastrarPessoas = new JLabel("    Não implementado :(");
        mensagemTelaCadastrarPessoas.setBounds(0, 0, 1200, 600);
        mensagemTelaCadastrarPessoas.setFont(new Font("Arial", Font.BOLD, 100));
        add(mensagemTelaCadastrarPessoas);
    }

    /**
     * Constroi um painel para edição de dados da Classe pessoa.
     * 
     * @param dados Base de dados
     * @param nome  Nome do pessoa a ser editado/atualizado
     */
    public TelaDetalhePessoa(Dados dados, String nome) {
        this(dados);
    }
}