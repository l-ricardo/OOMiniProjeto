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
import model.Jornal;
import model.NovelaFilmeSerie;
import model.Personagem;
import model.Pessoa;
import model.Programa;
import model.TalkShow;

/**
 * Classe que modela uma tela de conteúdo que estende de JPanel, com as
 * funcionalidades de criação e edição de programas.
 */
public class TelaDetalhePrograma extends JPanel implements ActionListener {
    private Dados d;
    private Programa programaDetalhado;

    private BotaoPequeno salvar, atualizar;
    private BotaoRadialCustomizado talkShow, jornal, novelaFilmeSerie;
    private CheckBoxCustomizada animado, fav;
    private CheckBoxCustomizada dom, seg, ter, qua, qui, sex, sab;
    private ArrayList<CheckBoxCustomizada> cbPersonagens;
    private ArrayList<CheckBoxCustomizada> cbAncoras, cbApresentadores, cbMusicos;
    private ArrayList<CheckBoxCustomizada> cbConvidados;
    private JLabel dicaTipoPrograma, legendaTipoPrograma;
    private JLabel dicaPersonagem, dicaNumTemporadas, dicaNumEpisodios, dicaAnimacao;
    private JLabel dicaAncora, dicaLocalidade;
    private JLabel dicaConvidado, dicaApresentador, dicaMusico;
    private CampoDados caixaNome, caixaHorario, caixaDuracao, caixaDescricao;
    private CampoDados caixaNumTemporadas, caixaNumEpisodios;
    private CampoDados caixaLocalidade;
    private JScrollPane painelPersonagensRolavel;
    private JScrollPane painelAncorasRolavel, painelApresentadoresRolavel, painelMusicosRolavel;
    private JScrollPane painelConvidadosRolavel;

    /**
     * Constroi um painel para cadastro de dados da Classe Programa.
     * 
     * @param dados Base de dados
     */
    public TelaDetalhePrograma(Dados dados) {
        this.d = dados;

        // Configurando painel
        this.setLayout(null);
        this.setBounds(0, 200, 1200, 600);
        this.setBackground(new Color(126, 121, 121));

        // ------------------ Componentes tipo programa ------------------
        dicaTipoPrograma = new JLabel("Tipo de programa:");
        dicaTipoPrograma.setBounds(100, 30, 300, 30);
        legendaTipoPrograma = new JLabel(" TalkShow              Jornal          Novela/Filme/Serie");
        legendaTipoPrograma.setBounds(100, 80, 300, 30);
        talkShow = new BotaoRadialCustomizado("Talk Show", 115, 60);
        jornal = new BotaoRadialCustomizado("Jornal", 210, 60);
        novelaFilmeSerie = new BotaoRadialCustomizado("Novela, filme ou serie", 310, 60);

        ButtonGroup grupoBotoesTipo = new ButtonGroup();
        grupoBotoesTipo.add(talkShow);
        grupoBotoesTipo.add(jornal);
        grupoBotoesTipo.add(novelaFilmeSerie);

        talkShow.addActionListener(this);
        jornal.addActionListener(this);
        novelaFilmeSerie.addActionListener(this);

        // --------------------------- Componentes nome ---------------------------
        JLabel dicaNome = new JLabel("Nome:");
        dicaNome.setBounds(100, 100, 300, 30);
        caixaNome = new CampoDados("Insira aqui o nome do programa...", 100, 130);
        caixaNome.setSize(275, 30);

        // -------------------------- Componente favorito --------------------------
        fav = new CheckBoxCustomizada("f", 377, 131);
        fav.setBackground(new Color(126, 121, 121));

        // --------------------- Componentes dias de exibição ---------------------
        JLabel dicaDiasExibicao = new JLabel("Dias de exibição:");
        dicaDiasExibicao.setBounds(100, 175, 300, 30);
        dom = new CheckBoxCustomizada("d", 100, 205);
        seg = new CheckBoxCustomizada("s", 125, 205);
        ter = new CheckBoxCustomizada("t", 150, 205);
        qua = new CheckBoxCustomizada("q", 175, 205);
        qui = new CheckBoxCustomizada("q", 200, 205);
        sex = new CheckBoxCustomizada("s", 225, 205);
        sab = new CheckBoxCustomizada("s", 250, 205);

        // -------------------------- Componentes horário --------------------------
        JLabel dicaHorario = new JLabel("Horário (HH:MM):");
        dicaHorario.setBounds(100, 240, 300, 30);
        caixaHorario = new CampoDados("Quando começa...", 100, 270);
        caixaHorario.setSize(150, 30);

        // -------------------------- Componentes duração --------------------------
        JLabel dicaDuracao = new JLabel("Duração:");
        dicaDuracao.setBounds(250, 240, 300, 30);
        caixaDuracao = new CampoDados("Quanto tempo dura...", 250, 270);
        caixaDuracao.setSize(150, 30);

        // ------------------------- Componentes descrição -------------------------
        JLabel dicaDescricao = new JLabel("Descrição:");
        dicaDescricao.setBounds(100, 315, 275, 30);
        caixaDescricao = new CampoDados("Insira aqui a descrição do programa...", 100, 345);

        // ------------------------ Componentes localidade ------------------------
        dicaLocalidade = new JLabel("Localidade:");
        dicaLocalidade.setBounds(800, 30, 300, 30);
        caixaLocalidade = new CampoDados("Insira aqui em que esfera o jornal é exibido...", 800, 60);

        // ------------------------ Componentes temporadas ------------------------
        dicaNumTemporadas = new JLabel("Número de temporadas:");
        dicaNumTemporadas.setBounds(800, 30, 300, 30);
        caixaNumTemporadas = new CampoDados("Quantas temporadas...", 800, 60);
        caixaNumTemporadas.setSize(150, 30);

        // ------------------------- Componentes episodios -------------------------
        dicaNumEpisodios = new JLabel("Número de episódios:");
        dicaNumEpisodios.setBounds(950, 30, 300, 30);
        caixaNumEpisodios = new CampoDados("Quantos episódios?", 950, 60);
        caixaNumEpisodios.setSize(150, 30);

        // -------------------------- Componente animado --------------------------
        dicaAnimacao = new JLabel("Animação?");
        dicaAnimacao.setBounds(840, 100, 275, 30);
        animado = new CheckBoxCustomizada("Animação", 800, 100);

        // ----------------------- Componentes personagens ------------------------
        dicaPersonagem = new JLabel("Personagens:");
        dicaPersonagem.setBounds(450, 30, 300, 30);

        cbPersonagens = new ArrayList<>(); // Inicializa array de checkboxes
        for (Personagem personagem : d.getPersonagens()) {
            CheckBoxCustomizada cb = new CheckBoxCustomizada(personagem.toString(), 0, 0);
            cbPersonagens.add(cb);
        }

        JPanel painelPersonagens = new JPanel(); // Cria painel onde ficam as checkboxes
        painelPersonagens.setLayout(new BoxLayout(painelPersonagens, BoxLayout.Y_AXIS));
        painelPersonagens.setBackground(new Color(50, 48, 48));
        for (CheckBoxCustomizada cb : cbPersonagens) {
            painelPersonagens.add(cb);
        }

        painelPersonagensRolavel = new JScrollPane(painelPersonagens);
        painelPersonagensRolavel.setBounds(450, 60, 300, 430);
        painelPersonagensRolavel.setBorder(BorderFactory.createEtchedBorder());
        painelPersonagensRolavel.setBackground(new Color(50, 48, 48));

        // -------------------------- Componentes âncoras ---------------------------
        dicaAncora = new JLabel("Âncoras:");
        dicaAncora.setBounds(450, 30, 300, 30);

        cbAncoras = new ArrayList<>(); // Inicializa array de checkboxes
        for (Artista ancora : d.getAncoras()) {
            CheckBoxCustomizada cb = new CheckBoxCustomizada(ancora.toString(), 0, 0);
            cbAncoras.add(cb);
        }

        JPanel painelAncoras = new JPanel(); // Cria painel onde ficam as checkboxes
        painelAncoras.setLayout(new BoxLayout(painelAncoras, BoxLayout.Y_AXIS));
        painelAncoras.setBackground(new Color(50, 48, 48));
        for (CheckBoxCustomizada cb : cbAncoras) {
            painelAncoras.add(cb);
        }

        painelAncorasRolavel = new JScrollPane(painelAncoras);
        painelAncorasRolavel.setBounds(450, 60, 300, 430);
        painelAncorasRolavel.setBorder(BorderFactory.createEtchedBorder());
        painelAncorasRolavel.setBackground(new Color(50, 48, 48));

        // ---------------------- Componentes apresentadores -----------------------
        dicaApresentador = new JLabel("Apresentadores:");
        dicaApresentador.setBounds(450, 30, 300, 30);

        cbApresentadores = new ArrayList<>(); // Inicializa array de checkboxes
        for (Artista apresentador : d.getArtistas()) {
            CheckBoxCustomizada cb = new CheckBoxCustomizada(apresentador.toString(), 0, 0);
            cbApresentadores.add(cb);
        }

        JPanel painelApresentadores = new JPanel(); // Cria painel onde ficam as checkboxes
        painelApresentadores.setLayout(new BoxLayout(painelApresentadores, BoxLayout.Y_AXIS));
        painelApresentadores.setBackground(new Color(50, 48, 48));
        for (CheckBoxCustomizada cb : cbApresentadores) {
            painelApresentadores.add(cb);
        }

        painelApresentadoresRolavel = new JScrollPane(painelApresentadores);
        painelApresentadoresRolavel.setBounds(450, 60, 300, 430);
        painelApresentadoresRolavel.setBorder(BorderFactory.createEtchedBorder());
        painelApresentadoresRolavel.setBackground(new Color(50, 48, 48));

        // ------------------------- Componentes musicos --------------------------
        dicaMusico = new JLabel("Musicos:");
        dicaMusico.setBounds(800, 30, 300, 30);

        cbMusicos = new ArrayList<>(); // Inicializa array de checkboxes
        for (Artista musico : d.getMusicos()) {
            CheckBoxCustomizada cb = new CheckBoxCustomizada(musico.toString(), 0, 0);
            cbMusicos.add(cb);
        }

        JPanel painelMusicos = new JPanel(); // Cria painel onde ficam as checkboxes
        painelMusicos.setLayout(new BoxLayout(painelMusicos, BoxLayout.Y_AXIS));
        painelMusicos.setBackground(new Color(50, 48, 48));
        for (CheckBoxCustomizada cb : cbMusicos) {
            painelMusicos.add(cb);
        }

        painelMusicosRolavel = new JScrollPane(painelMusicos);
        painelMusicosRolavel.setBounds(800, 60, 300, 200);
        painelMusicosRolavel.setBorder(BorderFactory.createEtchedBorder());
        painelMusicosRolavel.setBackground(new Color(50, 48, 48));

        // ------------------------ Componentes convidados -------------------------
        dicaConvidado = new JLabel("Convidados:");
        dicaConvidado.setBounds(800, 260, 300, 30);

        cbConvidados = new ArrayList<>(); // Inicializa array de checkboxes
        for (Pessoa convidados : d.getPessoas()) {
            CheckBoxCustomizada cb = new CheckBoxCustomizada(convidados.toString(), 0, 0);
            cbConvidados.add(cb);
        }

        JPanel painelConvidados = new JPanel(); // Cria painel onde ficam as checkboxes
        painelConvidados.setLayout(new BoxLayout(painelConvidados, BoxLayout.Y_AXIS));
        painelConvidados.setBackground(new Color(50, 48, 48));
        for (CheckBoxCustomizada cb : cbConvidados) {
            painelConvidados.add(cb);
        }

        painelConvidadosRolavel = new JScrollPane(painelConvidados);
        painelConvidadosRolavel.setBounds(800, 290, 300, 200);
        painelConvidadosRolavel.setBorder(BorderFactory.createEtchedBorder());
        painelConvidadosRolavel.setBackground(new Color(50, 48, 48));

        // ----------------------------- Botão salvar ------------------------------
        salvar = new BotaoPequeno("Salvar", 100, 460);
        salvar.addActionListener(this);
        // -------------------------------------------------------------------------

        // Adicionando componentes ao painel
        this.add(dicaTipoPrograma);
        this.add(legendaTipoPrograma);
        this.add(novelaFilmeSerie);
        this.add(jornal);
        this.add(talkShow);
        this.add(dicaNome);
        this.add(caixaNome);
        this.add(fav);
        this.add(dicaDiasExibicao);
        this.add(dom);
        this.add(seg);
        this.add(ter);
        this.add(qua);
        this.add(qui);
        this.add(sex);
        this.add(sab);
        this.add(dicaHorario);
        this.add(caixaHorario);
        this.add(dicaDuracao);
        this.add(caixaDuracao);
        this.add(dicaDescricao);
        this.add(caixaDescricao);

        this.add(dicaNumTemporadas);
        this.add(caixaNumTemporadas);
        this.add(dicaNumEpisodios);
        this.add(caixaNumEpisodios);
        this.add(dicaAnimacao);
        this.add(animado);
        this.add(dicaPersonagem);
        this.add(painelPersonagensRolavel);

        this.add(dicaLocalidade);
        this.add(caixaLocalidade);
        this.add(dicaAncora);
        this.add(painelAncorasRolavel);

        this.add(dicaApresentador);
        this.add(painelApresentadoresRolavel);
        this.add(dicaMusico);
        this.add(painelMusicosRolavel);
        this.add(dicaConvidado);
        this.add(painelConvidadosRolavel);

        modoTalkShow();
        this.talkShow.setSelected(true);
        this.add(salvar);
    }

    /**
     * Constroi um painel para edição de dados da Classe Programa.
     * 
     * @param dados Base de dados
     * @param nome  Nome do programa a ser editado/atualizado
     */
    public TelaDetalhePrograma(Dados dados, String nome) {
        this(dados);

        dicaTipoPrograma.setVisible(false);
        legendaTipoPrograma.setVisible(false);
        talkShow.setVisible(false);
        jornal.setVisible(false);
        novelaFilmeSerie.setVisible(false);

        // Encontra o programa que se quer visualizar
        this.programaDetalhado = d.getPrograma(nome);

        // Preenche os campos com os dados do programa
        caixaNome.setText(programaDetalhado.getNome());
        for (int dia : programaDetalhado.getDiasExibicao()) {
            switch (dia) {
                case 1:
                    dom.setSelected(true);
                    break;
                case 2:
                    seg.setSelected(true);
                    break;
                case 3:
                    ter.setSelected(true);
                    break;
                case 4:
                    qua.setSelected(true);
                    break;
                case 5:
                    qui.setSelected(true);
                    break;
                case 6:
                    sex.setSelected(true);
                    break;
                case 7:
                    sab.setSelected(true);
                    break;
            }
        }
        caixaHorario.setText(programaDetalhado.getHorario());
        caixaDuracao.setText(String.valueOf(programaDetalhado.getDuracaoMin()));
        caixaDescricao.setText(programaDetalhado.getDescricao());
        fav.setSelected(programaDetalhado.isFavorito());

        // Configura a interface para o tipo de programa a ser visualizado e preenche
        // dados restantes
        if (programaDetalhado instanceof TalkShow) {
            modoTalkShow();
            talkShow.setSelected(true);
            TalkShow talkShowDetalhado = (TalkShow) programaDetalhado;
            for (CheckBoxCustomizada cb : cbApresentadores) {
                // Itera sobre os checkboxes e marca ele como selecionado se existir dentro do
                // programa que esta sendo detalhado uma pessoa com o nome do texto do botao
                if (talkShowDetalhado.existeApresentador(cb.getText())) {
                    cb.setSelected(true);
                }
            }
            for (CheckBoxCustomizada cb : cbMusicos) {
                // Itera sobre os checkboxes e marca ele como selecionado se existir dentro do
                // programa que esta sendo detalhado uma pessoa com o nome do texto do botao
                if (talkShowDetalhado.existeMusico(cb.getText())) {
                    cb.setSelected(true);
                }
            }
            for (CheckBoxCustomizada cb : cbConvidados) {
                // Itera sobre os checkboxes e marca ele como selecionado se existir dentro do
                // programa que esta sendo detalhado uma pessoa com o nome do texto do botao
                if (talkShowDetalhado.existeConvidado(cb.getText())) {
                    cb.setSelected(true);
                }
            }
        } else if (programaDetalhado instanceof NovelaFilmeSerie) {
            modoNovelaFilmeSerie();
            novelaFilmeSerie.setSelected(true);
            NovelaFilmeSerie novelaFilmeSerieDetalhado = (NovelaFilmeSerie) programaDetalhado;
            caixaNumTemporadas.setText(String.valueOf(novelaFilmeSerieDetalhado.getnTemporadas()));
            caixaNumEpisodios.setText(String.valueOf(novelaFilmeSerieDetalhado.getnTotalEpisodios()));
            animado.setSelected(novelaFilmeSerieDetalhado.isAnimado());
            for (CheckBoxCustomizada cb : cbPersonagens) {
                // Itera sobre os checkboxes e marca ele como selecionado se existir dentro do
                // programa que esta sendo detalhado uma pessoa com o nome do texto do botao
                if (novelaFilmeSerieDetalhado.existePersonagem(cb.getText())) {
                    cb.setSelected(true);
                }
            }
        } else if (programaDetalhado instanceof Jornal) {
            modoJornal();
            jornal.setSelected(true);
            Jornal jornalDetalhado = (Jornal) programaDetalhado;
            caixaLocalidade.setText(jornalDetalhado.getLocalidade());
            for (CheckBoxCustomizada cb : cbAncoras) {
                // Itera sobre os checkboxes e marca ele como selecionado se existir dentro do
                // programa que esta sendo detalhado uma pessoa com o nome do texto do botao
                if (jornalDetalhado.existeAncora(cb.getText())) {
                    cb.setSelected(true);
                }
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
     * @return Um novo programa cadastrado da classe Programa
     */
    private Programa cadastroNovoPrograma() {
        ArrayList<Integer> dias = getDiasSelecionados();
        if (talkShow.isSelected()) {
            TalkShow novoPrograma = new TalkShow(
                    caixaNome.getText(),
                    dias,
                    caixaHorario.getText(),
                    Integer.parseInt(caixaDuracao.getText()));
            novoPrograma.setFavorito(fav.isSelected());
            novoPrograma.setDescricao(caixaDescricao.getText());
            for (CheckBoxCustomizada cb : cbApresentadores) {
                // Itera sobre os checkboxes e se ele esta selecionado adiciona a pessoa com
                // mesmo nome ao novo programa
                if (cb.isSelected()) {
                    novoPrograma.getApresentadores().add((Artista) (d.getPessoa(cb.getText())));
                }
            }
            for (CheckBoxCustomizada cb : cbMusicos) {
                // Itera sobre os checkboxes e se ele esta selecionado adiciona a pessoa com
                // mesmo nome ao novo programa
                if (cb.isSelected()) {
                    novoPrograma.getMusicos().add((Artista) (d.getPessoa(cb.getText())));
                }
            }
            for (CheckBoxCustomizada cb : cbConvidados) {
                // Itera sobre os checkboxes e se ele esta selecionado adiciona a pessoa com
                // mesmo nome ao novo programa
                if (cb.isSelected()) {
                    novoPrograma.getConvidados().add(d.getPessoa(cb.getText()));
                }
            }
            return novoPrograma;

        } else if (jornal.isSelected()) {
            Jornal novoPrograma = new Jornal(
                    caixaNome.getText(),
                    dias,
                    caixaHorario.getText(),
                    Integer.parseInt(caixaDuracao.getText()));
            novoPrograma.setLocalidade(caixaLocalidade.getText());
            novoPrograma.setFavorito(fav.isSelected());
            novoPrograma.setDescricao(caixaDescricao.getText());
            for (CheckBoxCustomizada cb : cbAncoras) {
                // Itera sobre os checkboxes e se ele esta selecionado adiciona a pessoa com
                // mesmo nome ao novo programa
                if (cb.isSelected()) {
                    novoPrograma.getAncoras().add((Artista) (d.getPessoa(cb.getText())));
                }
            }
            return novoPrograma;

        } else {
            NovelaFilmeSerie novoPrograma = new NovelaFilmeSerie(
                    caixaNome.getText(),
                    dias,
                    caixaHorario.getText(),
                    Integer.parseInt(caixaDuracao.getText()));
            novoPrograma.setnTemporadas(Integer.parseInt(caixaNumTemporadas.getText()));
            novoPrograma.setnTotalEpisodios(Integer.parseInt(caixaNumEpisodios.getText()));
            novoPrograma.setFavorito(fav.isSelected());
            novoPrograma.setAnimado(animado.isSelected());
            novoPrograma.setDescricao(caixaDescricao.getText());
            for (CheckBoxCustomizada cb : cbPersonagens) {
                // Itera sobre os checkboxes e se ele esta selecionado adiciona a pessoa com
                // mesmo nome ao novo programa
                if (cb.isSelected()) {
                    novoPrograma.getPersonagens().add((Personagem) (d.getPessoa(cb.getText())));
                }
            }
            return novoPrograma;
        }
    }

    /**
     * Configura a interface para o cadastro de um programa do tipo Jornal.
     */
    private void modoJornal() {
        dicaNumTemporadas.setVisible(false);
        caixaNumTemporadas.setVisible(false);
        dicaNumEpisodios.setVisible(false);
        caixaNumEpisodios.setVisible(false);
        dicaAnimacao.setVisible(false);
        animado.setVisible(false);
        dicaPersonagem.setVisible(false);
        painelPersonagensRolavel.setVisible(false);

        dicaLocalidade.setVisible(true);
        caixaLocalidade.setVisible(true);
        dicaAncora.setVisible(true);
        painelAncorasRolavel.setVisible(true);

        dicaApresentador.setVisible(false);
        painelApresentadoresRolavel.setVisible(false);
        dicaMusico.setVisible(false);
        painelMusicosRolavel.setVisible(false);
        dicaConvidado.setVisible(false);
        painelConvidadosRolavel.setVisible(false);
    }

    /**
     * Configura a interface para o cadastro de um programa do tipo Novela, Filme ou
     * Serie.
     */
    private void modoNovelaFilmeSerie() {
        dicaNumTemporadas.setVisible(true);
        caixaNumTemporadas.setVisible(true);
        dicaNumEpisodios.setVisible(true);
        caixaNumEpisodios.setVisible(true);
        dicaAnimacao.setVisible(true);
        animado.setVisible(true);
        dicaPersonagem.setVisible(true);
        painelPersonagensRolavel.setVisible(true);

        dicaLocalidade.setVisible(false);
        caixaLocalidade.setVisible(false);
        dicaAncora.setVisible(false);
        painelAncorasRolavel.setVisible(false);

        dicaApresentador.setVisible(false);
        painelApresentadoresRolavel.setVisible(false);
        dicaMusico.setVisible(false);
        painelMusicosRolavel.setVisible(false);
        dicaConvidado.setVisible(false);
        painelConvidadosRolavel.setVisible(false);
    }

    /**
     * Configura a interface para o cadastro de um programa do tipo TalkShow.
     */
    private void modoTalkShow() {
        dicaNumTemporadas.setVisible(false);
        caixaNumTemporadas.setVisible(false);
        dicaNumEpisodios.setVisible(false);
        caixaNumEpisodios.setVisible(false);
        dicaAnimacao.setVisible(false);
        animado.setVisible(false);
        dicaPersonagem.setVisible(false);
        painelPersonagensRolavel.setVisible(false);

        dicaLocalidade.setVisible(false);
        caixaLocalidade.setVisible(false);
        dicaAncora.setVisible(false);
        painelAncorasRolavel.setVisible(false);

        dicaApresentador.setVisible(true);
        painelApresentadoresRolavel.setVisible(true);
        dicaMusico.setVisible(true);
        painelMusicosRolavel.setVisible(true);
        dicaConvidado.setVisible(true);
        painelConvidadosRolavel.setVisible(true);
    }

    /**
     * Cria um array com os dias selecionados no filtro de dias.
     * 
     * @return Array de inteiros onde 1 representa domingo, 2 representa segunda,
     *         3 representa terça, etc...
     */
    private ArrayList<Integer> getDiasSelecionados() {
        ArrayList<Integer> dias = new ArrayList<Integer>();
        if (dom.isSelected()) {
            dias.add(1);
        }
        if (seg.isSelected()) {
            dias.add(2);
        }
        if (ter.isSelected()) {
            dias.add(3);
        }
        if (qua.isSelected()) {
            dias.add(4);
        }
        if (qui.isSelected()) {
            dias.add(5);
        }
        if (sex.isSelected()) {
            dias.add(6);
        }
        if (sab.isSelected()) {
            dias.add(7);
        }
        return dias;
    }

    // --------------------------------- Listeners ---------------------------------
    /**
     * Detecta quando os botões "salvar" e "atualizar" são clicados além de
     * verificar se os campos nome e número foram preenchidos corretamente e, se
     * sim, cria ou atualiza um objeto Programa com as informações fornecidas.
     *
     * @param e O evento detectado pelo sistema
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();

        // Muda os campos de preenchimento comforme o tipo de programa selecionado
        if (clicado == talkShow) {
            modoTalkShow();
        }
        if (clicado == novelaFilmeSerie) {
            modoNovelaFilmeSerie();
        }
        if (clicado == jornal) {
            modoJornal();
        }

        if (clicado == salvar) {
            if (caixaNome.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo nome é de preenchimento obrigatório.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (getDiasSelecionados().size() == 0) {
                JOptionPane.showMessageDialog(null,
                        "A seleção de pelo menos um dia se exibição é obrigatória",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaHorario.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo horário é de preenchimento obrigatório.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaHorario.isHorarioInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo horário deve obedecer o formato HH:MM.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaDuracao.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo duração é de preenchimento obrigatório.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaDuracao.isNumeroInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo duração só suporta números",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else {
                if (talkShow.isSelected()) {
                    d.getProgramaTipoTalkShow().add((TalkShow) cadastroNovoPrograma());
                    // Desabilita o botao para evitar cadastro duplicado
                    salvar.setEnabled(false);

                } else if (jornal.isSelected()) {
                    d.getProgramaTipoJornal().add((Jornal) cadastroNovoPrograma());
                    // Desabilita o botao para evitar cadastro duplicado
                    salvar.setEnabled(false);

                } else if (novelaFilmeSerie.isSelected()) {
                    if (caixaNumTemporadas.isTextoInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo temporadas é de preenchimento obrigatório.",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else if (caixaNumTemporadas.isNumeroInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo temporadas só suporta números",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else if (caixaNumEpisodios.isTextoInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo episódios é de preenchimento obrigatório.",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else if (caixaNumEpisodios.isNumeroInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo episódios só suporta números",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else {
                        d.getProgramaTipoNovelaFilmeSerie().add((NovelaFilmeSerie) cadastroNovoPrograma());
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
            } else if (getDiasSelecionados().size() == 0) {
                JOptionPane.showMessageDialog(null,
                        "A seleção de pelo menos um dia se exibição é obrigatória",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaHorario.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo horário é de preenchimento obrigatório.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaHorario.isHorarioInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo horário deve obedecer o formato HH:MM.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaDuracao.isTextoInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo duração é de preenchimento obrigatório.",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else if (caixaDuracao.isNumeroInvalido()) {
                JOptionPane.showMessageDialog(null,
                        "O campo duração só suporta números",
                        "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
            } else {
                if (talkShow.isSelected()) {
                    d.getProgramaTipoTalkShow().set(d.getProgramaTipoTalkShow().indexOf(programaDetalhado),
                            (TalkShow) cadastroNovoPrograma());
                    // Desabilita o botao para evitar cadastro duplicado
                    atualizar.setEnabled(false);

                } else if (jornal.isSelected()) {
                    d.getProgramaTipoJornal().set(d.getProgramaTipoJornal().indexOf(programaDetalhado),
                            (Jornal) cadastroNovoPrograma());
                    // Desabilita o botao para evitar cadastro duplicado
                    atualizar.setEnabled(false);

                } else if (novelaFilmeSerie.isSelected()) {
                    if (caixaNumTemporadas.isTextoInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo temporadas é de preenchimento obrigatório.",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else if (caixaNumTemporadas.isNumeroInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo temporadas só suporta números",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else if (caixaNumEpisodios.isTextoInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo episódios é de preenchimento obrigatório.",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else if (caixaNumEpisodios.isNumeroInvalido()) {
                        JOptionPane.showMessageDialog(null,
                                "O campo episódios só suporta números",
                                "Fora de sintonia", JOptionPane.ERROR_MESSAGE);
                    } else {
                        d.getProgramaTipoNovelaFilmeSerie().set(
                                d.getProgramaTipoNovelaFilmeSerie().indexOf(programaDetalhado),
                                (NovelaFilmeSerie) cadastroNovoPrograma());
                        // Desabilita o botao para evitar cadastro duplicado
                        atualizar.setEnabled(false);
                    }
                }
            }
        }
    }
}