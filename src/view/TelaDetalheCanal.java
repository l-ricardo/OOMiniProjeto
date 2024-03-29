package view;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Canal;
import model.Dados;
import model.Programa;

/**
 * Classe que modela uma tela de conteúdo que estende de JPanel, com as
 * funcionalidades de criação e edição de canais.
 */
public class TelaDetalheCanal extends JPanel implements ActionListener {
    private Dados d;
    private Canal canalDetalhado;

    private CampoDados caixaNome, caixaNumero;
    private BotaoPequeno salvar, atualizar;
    private ArrayList<CheckBoxCustomizada> cbProgramas;

    /**
     * Constroi um painel para cadastro de dados da Classe Canal.
     * 
     * @param dados Base de dados
     */
    public TelaDetalheCanal(Dados dados) {
        this.d = dados;

        // Configurando painel
        this.setLayout(null);
        this.setBounds(0, 200, 1200, 600);
        this.setBackground(new Color(126, 121, 121));

        // --------------------------- Componentes nome ---------------------------
        JLabel dicaNome = new JLabel("Nome:");
        dicaNome.setBounds(100, 30, 300, 30);
        caixaNome = new CampoDados("Insira aqui o nome do canal...", 100, 60);

        // -------------------------- Componentes número --------------------------
        JLabel dicaNumero = new JLabel("Número:");
        dicaNumero.setBounds(100, 130, 300, 30);
        caixaNumero = new CampoDados("Insira aqui o número do canal...", 100, 160);

        // -------------------------- Componentes programa---------------------------
        JLabel dicaPrograma = new JLabel("Programação:");
        dicaPrograma.setBounds(450, 30, 300, 30);

        cbProgramas = new ArrayList<>(); // Inicializa array de checkboxes
        for (Programa programa : d.getTodosProgramas()) {
            CheckBoxCustomizada cb = new CheckBoxCustomizada(programa.toString(), 0, 0);
            cbProgramas.add(cb);
        }

        JPanel painelProgramas = new JPanel(); // Cria painel onde ficam as checkboxes
        painelProgramas.setLayout(new BoxLayout(painelProgramas, BoxLayout.Y_AXIS));
        painelProgramas.setBackground(new Color(50, 48, 48));
        for (CheckBoxCustomizada cb : cbProgramas) {
            painelProgramas.add(cb);
        }

        JScrollPane painelProgramasRolavel = new JScrollPane(painelProgramas);
        painelProgramasRolavel.setBounds(450, 60, 300, 430);
        painelProgramasRolavel.setBorder(BorderFactory.createEtchedBorder());
        painelProgramasRolavel.setBackground(new Color(50, 48, 48));

        // ----------------------------- Botão salvar ------------------------------
        salvar = new BotaoPequeno("Salvar", 100, 460);
        salvar.addActionListener(this);
        // -------------------------------------------------------------------------

        // Adicionando componentes ao painel
        this.add(dicaNome);
        this.add(caixaNome);
        this.add(dicaNumero);
        this.add(caixaNumero);
        this.add(dicaPrograma);
        this.add(painelProgramasRolavel);
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
        this.canalDetalhado = d.getCanal(nome);

        // Preenche os campos com os dados do canal
        caixaNome.setText(canalDetalhado.getNome());
        caixaNumero.setText(String.valueOf(canalDetalhado.getNumero()));
        for (CheckBoxCustomizada cb : cbProgramas) {
            if (canalDetalhado.existePrograma(cb.getText())) {
                cb.setSelected(true);
            }
        }

        // Esconde o botão salvar que foi criado pelo this(dados)
        salvar.setVisible(false);

        // --------------------------- Botão atualizar ----------------------------
        atualizar = new BotaoPequeno("Atualizar", 100, 460);
        atualizar.addActionListener(this);
        // -------------------------------------------------------------------------

        // Adicionando componente ao painel
        this.add(atualizar);
        this.updateUI();
    }

    // ---------------------------- Metodos Auxiliares ----------------------------
    /**
     * Cria um novo objeto com base nos dados entrados pelo usuário nos campos de
     * texto e de checkbox.
     * 
     * @return Um novo canal cadastrado da classe Canal
     */
    private Canal cadastroNovoCanal() {
        Canal novoCanal = new Canal(caixaNome.getText(),
                Integer.parseInt(caixaNumero.getText()));
        // Adiciona os programas selecionados no novoCanal
        for (CheckBoxCustomizada cb : cbProgramas) {
            if (cb.isSelected()) {
                novoCanal.getProgramas().add(d.getPrograma(cb.getText()));
            }
        }
        return novoCanal;
    }

    // --------------------------------- Listeners ---------------------------------
    /**
     * Detecta quando os botões "salvar" e "atualizar" são clicados além de
     * verificar se os campos nome e número foram preenchidos corretamente e, se
     * sim, cria ou atualiza um objeto Canal com as informações fornecidas.
     * 
     * @param e O evento detectado pelo sistema
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();

        if (clicado == salvar) {
            if (caixaNome.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo nome é de preenchimento obrigatório.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaNumero.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo número é de preenchimento obrigatório ",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaNumero.isNumeroInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo número só suporta números",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else {
                d.getCanais().add(cadastroNovoCanal());
                // Desabilita o botao para evitar cadastro duplicado
                salvar.setEnabled(false);
            }
        }

        if (clicado == atualizar) {
            if (caixaNome.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo nome é de preenchimento obrigatório.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaNumero.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo número é de preenchimento obrigatório ",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaNumero.isNumeroInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo número só suporta números",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else {
                d.getCanais().set(d.getCanais().indexOf(canalDetalhado), cadastroNovoCanal());
                // Desabilita o botao para evitar cadastro duplicado
                atualizar.setEnabled(false);
            }
        }
    }
}