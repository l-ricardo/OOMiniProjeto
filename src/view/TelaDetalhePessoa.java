package view;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Artista;
import model.Dados;
import model.Personagem;
import model.Pessoa;

/**
 * Classe que modela uma tela de conteúdo que estende de JPanel, com as
 * funcionalidades de criação e edição de pessoas.
 */
public class TelaDetalhePessoa extends JPanel implements ActionListener {
    private Dados d;
    private String atorSelecionado;
    private Pessoa pessoaDetalhada;

    private BotaoPequeno salvar, atualizar;
    private BotaoRadialCustomizado pessoa, artista, personagem;
    private BotaoRadialCustomizado masculino, feminino;
    private CheckBoxCustomizada musico, ancora, protagonista;
    private ArrayList<BotaoRadialCustomizado> rbAtores;
    private JLabel dicaTipoPessoa, legendaTipoPessoa, dicaSexo, legendaSexo;
    private JLabel dicaTipo, dicaMusico, dicaInstrumento, dicaProtagonista;
    private JLabel dicaAtor, dicaAncora;
    private CampoDados caixaNome, caixaTipo, caixaInstrumento;
    private JScrollPane painelAtoresRolavel;

    /**
     * Constroi um painel para cadastro de dados da Classe Pessoa.
     * 
     * @param dados Base de dados
     */
    public TelaDetalhePessoa(Dados dados) {
        this.d = dados;

        // Configurando painel
        this.setLayout(null);
        this.setBounds(0, 200, 1200, 600);
        this.setBackground(new Color(126, 121, 121));

        // ------------------ Componentes tipo pessoa ------------------
        dicaTipoPessoa = new JLabel("Tipo de pessoa:");
        dicaTipoPessoa.setBounds(100, 30, 300, 30);
        legendaTipoPessoa = new JLabel(" Pessoa                 Artista                Personagem");
        legendaTipoPessoa.setBounds(100, 80, 300, 30);
        pessoa = new BotaoRadialCustomizado("Pessoa", 115, 60);
        artista = new BotaoRadialCustomizado("Artista", 210, 60);
        personagem = new BotaoRadialCustomizado("Personagem", 310, 60);

        ButtonGroup grupoBotoesTipo = new ButtonGroup();
        grupoBotoesTipo.add(pessoa);
        grupoBotoesTipo.add(artista);
        grupoBotoesTipo.add(personagem);

        pessoa.addActionListener(this);
        artista.addActionListener(this);
        personagem.addActionListener(this);

        // --------------------------- Componentes nome ---------------------------
        JLabel dicaNome = new JLabel("Nome:");
        dicaNome.setBounds(100, 100, 300, 30);
        caixaNome = new CampoDados("Insira aqui o nome da pessoa...", 100, 130);

        // --------------------------- Componentes sexo ---------------------------
        dicaSexo = new JLabel("Sexo:");
        dicaSexo.setBounds(100, 175, 300, 30);
        legendaSexo = new JLabel(" Masculino           Feminino");
        legendaSexo.setBounds(100, 225, 300, 30);
        masculino = new BotaoRadialCustomizado("M", 115, 205);
        feminino = new BotaoRadialCustomizado("F", 210, 205);

        ButtonGroup grupoBotoesSexo = new ButtonGroup();
        grupoBotoesSexo.add(masculino);
        grupoBotoesSexo.add(feminino);

        // ----------------------- Componentes tipo artista -----------------------
        dicaTipo = new JLabel("Tipo de artista:");
        dicaTipo.setBounds(450, 30, 300, 30);
        caixaTipo = new CampoDados("É humorista, apresentador, jornalista...", 450, 60);

        // -------------------------- Componentes instrumento --------------------------
        dicaInstrumento = new JLabel("Instrumento:");
        dicaInstrumento.setBounds(450, 100, 300, 30);
        caixaInstrumento = new CampoDados("Que instrumento toca?", 450, 130);

        // -------------------------- Componente musico --------------------------
        dicaMusico = new JLabel("Musico?");
        dicaMusico.setBounds(800, 30, 275, 30);
        musico = new CheckBoxCustomizada("Musico", 800, 60);

        // -------------------------- Componente ancora --------------------------
        dicaAncora = new JLabel("Ancora?");
        dicaAncora.setBounds(800, 100, 275, 30);
        ancora = new CheckBoxCustomizada("Ancora", 800, 130);

        // ----------------------- Componente protagonista -----------------------
        dicaProtagonista = new JLabel("Protagonista?");
        dicaProtagonista.setBounds(800, 30, 275, 30);
        protagonista = new CheckBoxCustomizada("f", 800, 60);
        protagonista.setBackground(new Color(126, 121, 121));

        // ------------------------ Componentes atores -------------------------
        dicaAtor = new JLabel("Atores:");
        dicaAtor.setBounds(450, 30, 300, 30);

        ButtonGroup grupoAtores = new ButtonGroup(); 
        rbAtores = new ArrayList<>(); // Inicializa array de checkboxes
        for (Pessoa ator : d.getPessoas()) {
            BotaoRadialCustomizado rb = new BotaoRadialCustomizado(ator.toString(), 0, 0); 
            grupoAtores.add(rb); 
            rbAtores.add(rb);
        }

        JPanel painelAtores = new JPanel(); // Cria painel onde ficam as checkboxes
        painelAtores.setLayout(new BoxLayout(painelAtores, BoxLayout.Y_AXIS));
        painelAtores.setBackground(new Color(50, 48, 48));
        for (BotaoRadialCustomizado rb : rbAtores) {
            painelAtores.add(rb);
        }

        painelAtoresRolavel = new JScrollPane(painelAtores);
        painelAtoresRolavel.setBounds(450, 60, 300, 430);
        painelAtoresRolavel.setBorder(BorderFactory.createEtchedBorder());
        painelAtoresRolavel.setBackground(new Color(50, 48, 48));

        // ----------------------------- Botão salvar ------------------------------
        salvar = new BotaoPequeno("Salvar", 100, 460);
        salvar.addActionListener(this);
        // -------------------------------------------------------------------------

        // Adicionando componentes ao painel
        this.add(dicaTipoPessoa);
        this.add(legendaTipoPessoa);
        this.add(artista);
        this.add(personagem);
        this.add(pessoa);

        this.add(dicaNome);
        this.add(caixaNome);

        this.add(dicaSexo);
        this.add(legendaSexo);
        this.add(masculino);
        this.add(feminino);

        this.add(dicaTipo);
        this.add(caixaTipo);

        this.add(dicaProtagonista);
        this.add(protagonista);

        this.add(dicaInstrumento);
        this.add(caixaInstrumento);

        this.add(dicaMusico);
        this.add(musico);

        this.add(dicaAncora);
        this.add(ancora);

        this.add(dicaAtor);
        this.add(painelAtoresRolavel);

        modoPessoa();
        this.pessoa.setSelected(true);
        this.add(salvar);
    }

    /**
     * Constroi um painel para edição de dados da Classe Pessoa.
     * 
     * @param dados Base de dados
     * @param nome  Nome do pessoa a ser editado/atualizado
     */
    public TelaDetalhePessoa(Dados dados, String nome) {
        this(dados);

        dicaTipoPessoa.setVisible(false);
        legendaTipoPessoa.setVisible(false);
        pessoa.setVisible(false);
        artista.setVisible(false);
        personagem.setVisible(false);

        // Encontra o pessoa que se quer visualizar
        this.pessoaDetalhada = d.getPessoa(nome);

        // Preenche os campos com os dados da pessoa
        caixaNome.setText(pessoaDetalhada.getNome());
        if (pessoaDetalhada.getSexo() == 'M') {
            masculino.setSelected(true);
            feminino.setSelected(false);
        } else {
            masculino.setSelected(false);
            feminino.setSelected(true);
        }

        // Configura a interface para o tipo de pessoa a ser visualizada
        // e preenche os dados
        if (pessoaDetalhada instanceof Personagem) {
            modoPersonagem();
            personagem.setSelected(true);
            Personagem personagemDetalhado = (Personagem) pessoaDetalhada;
            protagonista.setSelected(personagemDetalhado.isProtagonista());
            for (BotaoRadialCustomizado rb : rbAtores) {
                // Itera sobre os checkboxes e marca ele como selecionado se existir dentro da
                // pessoa que esta sendo detalhado uma pessoa com o nome do texto do botao
                if (personagemDetalhado.existeAtor(rb.getText())) {
                    rb.setSelected(true);
                    break;
                }
            }
        } else if (pessoaDetalhada instanceof Artista) {
            modoArtista();
            artista.setSelected(true);
            Artista artistaDetalhado = (Artista) pessoaDetalhada;
            caixaTipo.setText(artistaDetalhado.getTipo());
            caixaInstrumento.setText(artistaDetalhado.getInstrumento());
            musico.setSelected(artistaDetalhado.isMusico());
            ancora.setSelected(artistaDetalhado.isAncora());

        } else if (pessoaDetalhada instanceof Pessoa) {
            modoPessoa();
            pessoa.setSelected(true);
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
     * @return Uma nova pessoa cadastrada da classe Pessoa
     */
    private Pessoa cadastroNovaPessoa() {
        if (pessoa.isSelected()) {
            Pessoa novaPessoa = new Pessoa(
                    caixaNome.getText(),
                    masculino.isSelected() ? 'M' : 'F');
            return novaPessoa;

        } else if (artista.isSelected()) {
            Artista novaPessoa = new Artista(
                    caixaNome.getText(),
                    masculino.isSelected() ? 'M' : 'F',
                    caixaTipo.getText(),
                    caixaInstrumento.getText());
            novaPessoa.setMusico(musico.isSelected());
            novaPessoa.setAncora(ancora.isSelected());
            return novaPessoa;

        } else {
            Personagem novaPessoa = new Personagem(
                    caixaNome.getText(),
                    masculino.isSelected() ? 'M' : 'F',
                    d.getPessoa(atorSelecionado));
            return novaPessoa;
        }
    }

    /**
     * Configura a interface para o cadastro de um pessoa do tipo Pessoa.
     */
    private void modoPessoa() {

        dicaTipo.setVisible(false);
        caixaTipo.setVisible(false);
        dicaInstrumento.setVisible(false);
        caixaInstrumento.setVisible(false);
        dicaMusico.setVisible(false);
        musico.setVisible(false);
        dicaAncora.setVisible(false);
        ancora.setVisible(false);

        dicaProtagonista.setVisible(false);
        protagonista.setVisible(false);
        dicaAtor.setVisible(false);
        painelAtoresRolavel.setVisible(false);
    }

    /**
     * Configura a interface para o cadastro de um pessoa do tipo Artista.
     */
    private void modoArtista() {

        dicaTipo.setVisible(true);
        caixaTipo.setVisible(true);
        dicaInstrumento.setVisible(true);
        caixaInstrumento.setVisible(true);
        dicaMusico.setVisible(true);
        musico.setVisible(true);
        dicaAncora.setVisible(true);
        ancora.setVisible(true);

        dicaProtagonista.setVisible(false);
        protagonista.setVisible(false);
        dicaAtor.setVisible(false);
        painelAtoresRolavel.setVisible(false);
    }

    /**
     * Configura a interface para o cadastro de um pessoa do tipo Personagem.
     */
    private void modoPersonagem() {
        dicaTipo.setVisible(false);
        caixaTipo.setVisible(false);
        dicaInstrumento.setVisible(false);
        caixaInstrumento.setVisible(false);
        dicaMusico.setVisible(false);
        musico.setVisible(false);
        dicaAncora.setVisible(false);
        ancora.setVisible(false);

        dicaProtagonista.setVisible(true);
        protagonista.setVisible(true);
        dicaAtor.setVisible(true);
        painelAtoresRolavel.setVisible(true);
    }

    // --------------------------------- Listeners ---------------------------------
    /**
     * Detecta quando os botões "salvar" e "atualizar" são clicados além de
     * verificar se os campos nome e número foram preenchidos corretamente e, se
     * sim, cria ou atualiza um objeto Pessoa com as informações fornecidas.
     *
     * @param e O evento detectado pelo sistema
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();

        // Muda os campos de preenchimento comforme o tipo de pessoa selecionada
        if (clicado == pessoa) {
            modoPessoa();
        }
        if (clicado == personagem) {
            modoPersonagem();
        }
        if (clicado == artista) {
            modoArtista();
        }

        if (clicado == salvar) {
            if (caixaNome.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo nome é de preenchimento obrigatório.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);

            } else if (!((!masculino.isSelected() && feminino.isSelected())
                    || (masculino.isSelected() && !feminino.isSelected()))) {
                JOptionPane.showMessageDialog(null,
                        "E obrigatorio selecionar pelo menos um sexo.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else {
                if (pessoa.isSelected()) {
                    d.getPessoas().add((Pessoa) cadastroNovaPessoa());
                    // Desabilita o botao para evitar cadastro duplicado
                    salvar.setEnabled(false);

                } else if (artista.isSelected()) {
                    if (caixaTipo.isTextoInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo tipo é de preenchimento obrigatório.",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else if (caixaInstrumento.isTextoInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo instrumento é de preenchimento obrigatório.",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else {
                        d.getArtistas().add((Artista) cadastroNovaPessoa());
                        // Desabilita o botao para evitar cadastro duplicado
                        salvar.setEnabled(false);
                    }
                } else if (personagem.isSelected()) {

                    if (atorSelecionado != null) {
                        JOptionPane.showMessageDialog(null,
                                "A Selecao de pelo menos um ator é obrigatória.",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else {
                        d.getPersonagens().add((Personagem) cadastroNovaPessoa());
                        // Desabilita o botao para evitar cadastro duplicado
                        salvar.setEnabled(false);
                    }
                }
            }
        }

        if (clicado == atualizar) {
            if (caixaNome.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo nome é de preenchimento obrigatório.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);

            } else if (!((!masculino.isSelected() && feminino.isSelected())
                    || (masculino.isSelected() && !feminino.isSelected()))) {
                JOptionPane.showMessageDialog(null,
                        "E obrigatorio selecionar pelo menos um sexo.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else {
                if (pessoa.isSelected()) {
                    d.getPessoas().set(d.getPessoas().indexOf(pessoaDetalhada),
                            (Pessoa) cadastroNovaPessoa());
                    // Desabilita o botao para evitar cadastro duplicado
                    atualizar.setEnabled(false);

                } else if (artista.isSelected()) {
                    if (caixaTipo.isTextoInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo tipo é de preenchimento obrigatório.",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else if (caixaInstrumento.isTextoInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo instrumento é de preenchimento obrigatório.",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else {
                        d.getArtistas().set(d.getArtistas().indexOf(pessoaDetalhada),
                                (Artista) cadastroNovaPessoa());
                        // Desabilita o botao para evitar cadastro duplicado
                        atualizar.setEnabled(false);
                    }
                } else if (personagem.isSelected()) {
                    if (atorSelecionado != null) {
                        JOptionPane.showMessageDialog(null,
                                "A Selecao de pelo menos um ator é obrigatória.",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else {
                        d.getPersonagens().set(d.getPersonagens().indexOf(pessoaDetalhada),
                                (Personagem) cadastroNovaPessoa());
                        // Desabilita o botao para evitar cadastro duplicado
                        atualizar.setEnabled(false);
                    }
                }
            }
        }

        // Se o objeto clicado for um dos botões radiais, atorSelecionado recebe o
        // texto do último botão radial slecionado
        if (rbAtores.contains(clicado)) {
            atorSelecionado = e.getActionCommand();
        }
    }
}