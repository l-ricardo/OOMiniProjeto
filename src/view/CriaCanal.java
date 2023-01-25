package view;

import models.Dados;
import models.Canal;
import models.Programa;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.*;

public class CriaCanal extends JPanel implements ActionListener, FocusListener {
    Dados d;
    Canal canalDetalhado;

    JTextField caixaNome, caixaNumero;
    JButton salvar, atualizar;
    JList<JCheckBox> listaProgramas;
    ArrayList<JCheckBox> cbProgramas;

    /**
     * Constroi um painel para cadastro de dados da Classe Canal.
     * 
     * @param dados Base de dados
     */
    public CriaCanal(Dados dados) {
        d = dados;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 600));
        this.setBackground(new Color(126, 121, 121));

        // --------------------------- Componentes nome ---------------------------
        JLabel dicaNome = new JLabel("Nome:");
        dicaNome.setBounds(50, 70, 300, 30);
        caixaNome = new JTextField("Insira aqui o nome do canal...");
        caixaNome.setBounds(50, 100, 300, 30);
        caixaNome.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        caixaNome.setBackground(new Color(50, 48, 48));
        caixaNome.setBorder(BorderFactory.createEtchedBorder());
        caixaNome.setForeground(Color.white);
        caixaNome.setCaretColor(Color.white);
        caixaNome.addFocusListener(this);

        // -------------------------- Componentes número --------------------------
        JLabel dicaNumero = new JLabel("Número:");
        dicaNumero.setBounds(50, 170, 300, 30);
        caixaNumero = new JTextField("Insira aqui o número do canal...");
        caixaNumero.setBounds(50, 200, 300, 30);
        caixaNumero.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        caixaNumero.setBackground(new Color(50, 48, 48));
        caixaNumero.setBorder(BorderFactory.createEtchedBorder());
        caixaNumero.setForeground(Color.white);
        caixaNumero.setCaretColor(Color.white);
        caixaNumero.addFocusListener(this);

        // -------------------------- Componentes programa---------------------------
        JLabel dicaPrograma = new JLabel("Programação:");
        dicaPrograma.setBounds(400, 70, 300, 30);

        cbProgramas = new ArrayList<>(); // Inicializa array de checkboxes
        for (Programa programa : d.getProgramaTipoJornal()) {
            JCheckBox cb = new JCheckBox(programa.toString());
            cb.setFocusable(false);
            cb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            cb.setBackground(new Color(50, 48, 48));
            cb.setForeground(Color.white);
            cbProgramas.add(cb);
        }
        for (Programa programa : d.getProgramaTipoNovelaFilmeSerie()) {
            JCheckBox cb = new JCheckBox(programa.toString());
            cb.setFocusable(false);
            cb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            cb.setBackground(new Color(50, 48, 48));
            cb.setForeground(Color.white);
            cbProgramas.add(cb);
        }
        for (Programa programa : d.getProgramaTipoTalkShow()) {
            JCheckBox cb = new JCheckBox(programa.toString());
            cb.setFocusable(false);
            cb.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            cb.setBackground(new Color(50, 48, 48));
            cb.setForeground(Color.white);
            cbProgramas.add(cb);
        }

        JPanel listaProgramas = new JPanel(); // Cria painel onde ficam as checkboxes
        listaProgramas.setLayout(new BoxLayout(listaProgramas, BoxLayout.Y_AXIS));
        listaProgramas.setBackground(new Color(50, 48, 48));
        for (JCheckBox cb : cbProgramas) {
            listaProgramas.add(cb);
        }

        JScrollPane listaProgramasRolavel = new JScrollPane(listaProgramas);
        listaProgramasRolavel.setBounds(400, 100, 300, 300);
        listaProgramasRolavel.setBorder(BorderFactory.createEtchedBorder());
        listaProgramasRolavel.setBackground(new Color(50, 48, 48));

        // ----------------------------- Botão salvar ------------------------------
        salvar = new JButton("Salvar"); // TODO: Adicionar icone
        salvar.setBounds(50, 370, 150, 30);
        salvar.setFocusable(false);
        salvar.setBackground(new Color(50, 48, 48));
        salvar.setForeground(Color.white);
        salvar.setFont(new Font("Comic Sans", Font.BOLD, 10));
        salvar.setBorder(BorderFactory.createEtchedBorder());
        salvar.addActionListener(this);

        add(dicaNome);
        add(caixaNome);
        add(dicaNumero);
        add(caixaNumero);
        add(dicaPrograma);
        add(listaProgramasRolavel);
        add(salvar);
    }

    /**
     * Constroi um painel para edição de dados da Classe Canal.
     * 
     * @param dados Base de dados
     * @param nome  Nome do canal a ser editado/atualizado
     */
    public CriaCanal(Dados dados, String nome) {
        // Constroi o Jpanel sem o botão salvar
        this(dados);
        salvar.setVisible(false);

        canalDetalhado = d.acharCanal(nome);

        // Preenche os campos com os dados do canal
        caixaNome.setText(canalDetalhado.getNome());
        caixaNumero.setText(String.valueOf(canalDetalhado.getNumero()));

        for (JCheckBox cb : cbProgramas) {
            if (canalDetalhado.existePrograma(cb.getText())) {
                cb.setSelected(true);
            }
        }

        // ----------------------------- Botão atualizar ------------------------------
        atualizar = new JButton("Atualizar"); // TODO: Adicionar icone
        atualizar.setBounds(50, 370, 150, 30);
        atualizar.setFocusable(false);
        atualizar.setBackground(new Color(50, 48, 48));
        atualizar.setForeground(Color.white);
        atualizar.setFont(new Font("Comic Sans", Font.BOLD, 10));
        atualizar.setBorder(BorderFactory.createEtchedBorder());
        atualizar.addActionListener(this);

        add(atualizar);
        this.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();

        if (clicado == salvar) {
            // Checa se os campos nome e numero foram preenchidos corretamente
            if (caixaNome.getText() == "Insira aqui o nome do canal..."
                    || caixaNumero.getText() == "Insira aqui o número do canal..."
                    || !caixaNumero.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "O que pode ter dado errado:\n"
                        + " * O campo nome é de preenchimento obrigatório.\n"
                        + " * O campo número é de preenchimento obrigatório.\n"
                        + " * O camponúmero só pode ter números",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else {
                Canal novoCanal = new Canal(caixaNome.getText(),
                        Integer.parseInt(caixaNumero.getText()));
                // Adiciona os programas selecionas no novoCanal
                for (JCheckBox cb : cbProgramas) {
                    if (cb.isSelected()) {
                        novoCanal.getProgramas().add(d.acharPrograma(cb.getText()));
                    }
                }
                d.getCanais().add(novoCanal);

                // Desabilita o botao apos o primeiro cadastro para evitar o cadastro
                // duplicado a cada click
                caixaNome.setEditable(false);
                caixaNumero.setEditable(false);
                salvar.setEnabled(false);
                // TODO: Checar se ja existe um canal com o mesmo nome e numero cadastrado
            }
        }
        if (clicado == atualizar) {
            // Checa se os campos nome e numero foram preenchidos corretamente
            if (caixaNome.getText() == "Insira aqui o nome do canal..."
                    || caixaNumero.getText() == "Insira aqui o número do canal..."
                    || !caixaNumero.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null, "O que pode ter dado errado:\n"
                        + " * O campo nome é de preenchimento obrigatório.\n"
                        + " * O campo número é de preenchimento obrigatório.\n"
                        + " * O camponúmero só pode ter números",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else {
                Canal novoCanal = new Canal(caixaNome.getText(),
                        Integer.parseInt(caixaNumero.getText()));
                // Adiciona os programas selecionas no novoCanal
                for (JCheckBox cb : cbProgramas) {
                    if (cb.isSelected()) {
                        novoCanal.getProgramas().add(d.acharPrograma(cb.getText()));
                    }
                }
                d.getCanais().set(d.getCanais().indexOf(canalDetalhado), novoCanal);

                // Desabilita o botao apos o primeiro cadastro para evitar o cadastro
                // duplicado a cada click
                atualizar.setEnabled(false);
                caixaNome.setEditable(false);
                caixaNumero.setEditable(false);
                // TODO: Talvez remover a função de desabilitar o botao em favor de um lablel
                // TODO: com feefback "O canal está atualizado"

                // TODO: Fechar o Jdialog aqui
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object focado = e.getSource();

        if (focado == caixaNome && caixaNome.getText().equals("Insira aqui o nome do canal...")) {
            caixaNome.setText("");
        }
        if (focado == caixaNumero && caixaNumero.getText().equals("Insira aqui o número do canal...")) {
            caixaNumero.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object focado = e.getSource();

        if (focado == caixaNome && caixaNome.getText().isEmpty()) {
            caixaNome.setText("Insira aqui o nome do canal...");
        }
        if (focado == caixaNumero && caixaNumero.getText().isEmpty()) {
            caixaNumero.setText("Insira aqui o número do canal...");
        }
    }
}
