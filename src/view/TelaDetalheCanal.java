package view;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Canal;
import model.Dados;
import model.Programa;

/**
 * Cria uma tela de conteúdo que estende de JPanel, com as funcionalidades de
 * criação e edição de canais.
 */
public class TelaDetalheCanal extends JPanel implements ActionListener {
    Dados d;
    Canal canalDetalhado;

    CampoDados caixaNome, caixaNumero;
    BotaoPequeno salvar, atualizar;
    JList<JCheckBox> listaProgramas;
    ArrayList<JCheckBox> cbProgramas;

    /**
     * Constroi um painel para cadastro de dados da Classe Canal.
     * 
     * @param dados Base de dados
     */
    public TelaDetalheCanal(Dados dados) {
        this.d = dados;

        // Configurando painel
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1200, 600));
        this.setBackground(new Color(126, 121, 121));

        // --------------------------- Componentes nome ---------------------------
        JLabel dicaNome = new JLabel("Nome:");
        dicaNome.setBounds(50, 70, 300, 30);
        caixaNome = new CampoDados("Insira aqui o nome do canal...", 50, 100);

        // -------------------------- Componentes número --------------------------
        JLabel dicaNumero = new JLabel("Número:");
        dicaNumero.setBounds(50, 170, 300, 30);
        caixaNumero = new CampoDados("Insira aqui o número do canal...", 50, 200);

        // -------------------------- Componentes programa---------------------------
        JLabel dicaPrograma = new JLabel("Programação:");
        dicaPrograma.setBounds(400, 70, 300, 30);

        cbProgramas = new ArrayList<>(); // Inicializa array de checkboxes
        // TODO: Fazer metodos para retornar todos os programas juntos
        for (Programa programa : d.getProgramaTipoJornal()) {
            CheckBoxCustomizada cb = new CheckBoxCustomizada(programa.toString(), 0, 0);
            cbProgramas.add(cb);
        }
        for (Programa programa : d.getProgramaTipoNovelaFilmeSerie()) {
            CheckBoxCustomizada cb = new CheckBoxCustomizada(programa.toString(), 0, 0);
            cbProgramas.add(cb);
        }
        for (Programa programa : d.getProgramaTipoTalkShow()) {
            CheckBoxCustomizada cb = new CheckBoxCustomizada(programa.toString(), 0, 0);
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
        salvar = new BotaoPequeno("Salvar", 50, 370);
        salvar.addActionListener(this);
        // -------------------------------------------------------------------------

        // Adicionando componentes ao painel
        this.add(dicaNome);
        this.add(caixaNome);
        this.add(dicaNumero);
        this.add(caixaNumero);
        this.add(dicaPrograma);
        this.add(listaProgramasRolavel);
        this.add(salvar);
    }

    /**
     * Constroi um painel para edição de dados da Classe Canal.
     * 
     * @param dados Base de dados
     * @param nome  Nome do canal a ser editado/atualizado
     */
    public TelaDetalheCanal(Dados dados, String nome) {
        this(dados);

        // Encontra o canal que se quer visualizar
        this.canalDetalhado = d.acharCanal(nome);

        // Preenche os campos com os dados do canal
        caixaNome.setText(canalDetalhado.getNome());
        caixaNumero.setText(String.valueOf(canalDetalhado.getNumero()));
        for (JCheckBox cb : cbProgramas) {
            if (canalDetalhado.existePrograma(cb.getText())) {
                cb.setSelected(true);
            }
        }

        // Esconde o botão salvar que foi criado pelo this(dados)
        salvar.setVisible(false);

        // --------------------------- Botão atualizar ----------------------------
        atualizar = new BotaoPequeno("Atualizar", 50, 370);
        atualizar.addActionListener(this);
        // -------------------------------------------------------------------------

        // Adicionando componente ao painel
        this.add(atualizar);
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

}