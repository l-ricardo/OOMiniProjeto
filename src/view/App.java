package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Dados;

/**
 * Cria a tela principal do app onde fica o menu e o conteiner que é modificado
 * com o conteudo das outras telas.
 */
public class App extends JFrame implements ActionListener, FocusListener {
    Dados dados;

    BotaoGrande bListarCanais, bCadastrarCanais;
    BotaoGrande bListarProgramas, bCadastrarProgramas;
    BotaoGrande bListarPessoas, bCadastrarPessoas;
    BotaoGrande limparFiltros;
    JPanel conteudo = new JPanel();
    CampoFiltragem filtroCanal, filtroPrograma, filtroPessoa;
    JCheckBox dom, seg, ter, qua, qui, sex, sab;
    ImageIcon sIconOn, tIconOn, qIconOn, dIconOn;
    ImageIcon sIconOff, tIconOff, qIconOff, dIconOff;

    /**
     * Constroi um painel para com o menu principal.
     * 
     * @param d Base de dados
     */
    App(Dados d) {
        dados = d;

        // Configurando janela
        this.setTitle("TeleGUIAdo");
        this.setLayout(new BorderLayout());
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(50, 48, 48));

        // Criando um painel com o cabecalho
        JPanel cabecalho = new JPanel();
        cabecalho.setPreferredSize(new Dimension(1200, 200));
        cabecalho.setLayout(null);
        cabecalho.setBackground(new Color(50, 48, 48));

        // Colocando titulo
        JLabel titulo = new JLabel("<html><pre>Tele\n  GUIA\n do</pre></html>");
        titulo.setForeground(Color.white);
        titulo.setBounds(50, 0, 200, 200);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 50));

        // ------------------------- Componentes menu -------------------------
        bListarCanais = new BotaoGrande("Listar Canais", 300, 50);
        bCadastrarCanais = new BotaoGrande("Listar Canais", 300, 100);
        bListarProgramas = new BotaoGrande("Listar Canais", 500, 50);
        bCadastrarProgramas = new BotaoGrande("Listar Canais", 500, 100);
        bListarPessoas = new BotaoGrande("Listar Canais", 700, 50);
        bCadastrarPessoas = new BotaoGrande("Listar Canais", 700, 100);

        bListarCanais.addActionListener(this);
        bCadastrarCanais.addActionListener(this);
        bListarProgramas.addActionListener(this);
        bCadastrarProgramas.addActionListener(this);
        bListarPessoas.addActionListener(this);
        bCadastrarPessoas.addActionListener(this);

        // ------------------------- Componentes filtragem -------------------------
        JLabel dicaFiltragem = new JLabel("Filtros de listagem:");
        dicaFiltragem.setBounds(950, 20, 300, 30);
        dicaFiltragem.setForeground(Color.white);

        filtroCanal = new CampoFiltragem("Insira o nome do canal...", 950, 50);
        filtroPrograma = new CampoFiltragem("Insira o nome do programa...", 950, 75);
        filtroPessoa = new CampoFiltragem("Insira o nome da pessoa...", 950, 100);

        filtroCanal.addFocusListener(this);
        filtroPrograma.addFocusListener(this);
        filtroPessoa.addFocusListener(this);

        limparFiltros = new BotaoGrande("x", 1125, 25);
        limparFiltros.setSize(25, 25);
        limparFiltros.addActionListener(this);

        sIconOn = new ImageIcon("assets/s_on.png");
        tIconOn = new ImageIcon("assets/t_on.png");
        qIconOn = new ImageIcon("assets/q_on.png");
        dIconOn = new ImageIcon("assets/d_on.png");
        sIconOff = new ImageIcon("assets/s_off.png");
        tIconOff = new ImageIcon("assets/t_off.png");
        qIconOff = new ImageIcon("assets/q_off.png");
        dIconOff = new ImageIcon("assets/d_off.png");

        dom = new JCheckBox(dIconOff);
        seg = new JCheckBox(sIconOff);
        ter = new JCheckBox(tIconOff);
        qua = new JCheckBox(qIconOff);
        qui = new JCheckBox(qIconOff);
        sex = new JCheckBox(sIconOff);
        sab = new JCheckBox(sIconOff);

        dom.setSelectedIcon(dIconOn);
        seg.setSelectedIcon(sIconOn);
        ter.setSelectedIcon(tIconOn);
        qua.setSelectedIcon(qIconOn);
        qui.setSelectedIcon(qIconOn);
        sex.setSelectedIcon(sIconOn);
        sab.setSelectedIcon(sIconOn);

        dom.setBackground(new Color(50, 48, 48));
        seg.setBackground(new Color(50, 48, 48));
        ter.setBackground(new Color(50, 48, 48));
        qua.setBackground(new Color(50, 48, 48));
        qui.setBackground(new Color(50, 48, 48));
        sex.setBackground(new Color(50, 48, 48));
        sab.setBackground(new Color(50, 48, 48));

        dom.setBounds(952, 125, 25, 25);
        seg.setBounds(980, 125, 25, 25);
        ter.setBounds(1008, 125, 25, 25);
        qua.setBounds(1036, 125, 25, 25);
        qui.setBounds(1064, 125, 25, 25);
        sex.setBounds(1092, 125, 25, 25);
        sab.setBounds(1120, 125, 25, 25);

        // Adicionando componentes na tela
        cabecalho.add(filtroCanal);
        cabecalho.add(filtroPrograma);
        cabecalho.add(filtroPessoa);
        cabecalho.add(titulo);
        cabecalho.add(bListarCanais);
        cabecalho.add(bCadastrarCanais);
        cabecalho.add(bListarProgramas);
        cabecalho.add(bCadastrarProgramas);
        cabecalho.add(bListarPessoas);
        cabecalho.add(bCadastrarPessoas);
        cabecalho.add(dicaFiltragem);
        cabecalho.add(limparFiltros);
        cabecalho.add(dom);
        cabecalho.add(seg);
        cabecalho.add(ter);
        cabecalho.add(qua);
        cabecalho.add(qui);
        cabecalho.add(sex);
        cabecalho.add(sab);

        this.add(cabecalho, BorderLayout.NORTH);
        this.setVisible(true);
        this.requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();
        if (conteudo != null) {
            conteudo.setVisible(false);
        }
        if (clicado == bListarCanais) {
            if (!filtroCanal.getText().contains("Insira o nome do canal...")) {
                conteudo = new TelaListaCanais(dados, filtroCanal.getText());
            } else {
                conteudo = new TelaListaCanais(dados, null);
            }
        }
        if (clicado == bCadastrarCanais) {
            conteudo = new TelaDetalheCanal(dados);
        }
        if (clicado == bListarProgramas) {
            // Tela lista programa com filtro de dia e canal
            if ((filtroCanal.getText() != "Insira o nome do canal...") &&
                    (dom.isSelected() || seg.isSelected() || ter.isSelected()
                            || qua.isSelected() || qui.isSelected() || sex.isSelected()
                            || sab.isSelected())) {

                // conteudo = new TelaDetalhePrograma(dados, filtro);
            } else {
                // Tela lista programa sem filtro
                // conteudo = new TelaDetalhePrograma(dados);
            }
        }
        if (clicado == limparFiltros) {
            filtroCanal.setText("Insira o nome do canal...");
            filtroPrograma.setText("Insira o nome do programa...");
            filtroPessoa.setText("Insira o nome da pessoa...");
            dom.setSelected(false);
            seg.setSelected(false);
            ter.setSelected(false);
            qua.setSelected(false);
            qui.setSelected(false);
            sex.setSelected(false);
            sab.setSelected(false);
            this.requestFocusInWindow();
        }

        this.add(conteudo, BorderLayout.CENTER);
        conteudo.updateUI();
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object focado = e.getSource();

        if (focado == filtroCanal
                && filtroCanal.getText().equals("Insira o nome do canal...")) {
            filtroCanal.setText("");
        }
        if (focado == filtroPrograma
                && filtroPrograma.getText().equals("Insira o nome do programa...")) {
            filtroPrograma.setText("");
        }
        if (focado == filtroPessoa
                && filtroPessoa.getText().equals("Insira o nome da pessoa...")) {
            filtroPessoa.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object focado = e.getSource();

        if (focado == filtroCanal && filtroCanal.getText().isEmpty()) {
            filtroCanal.setText("Insira o nome do canal...");
        }
        if (focado == filtroPrograma && filtroPrograma.getText().isEmpty()) {
            filtroPrograma.setText("Insira o nome do programa...");
        }
        if (focado == filtroPessoa && filtroPessoa.getText().isEmpty()) {
            filtroPessoa.setText("Insira o nome da pessoa...");
        }
    }

    public static void main(String[] args) {
        Dados d = new Dados();
        new App(d);
        // TODO: Atualizar diagramas de classes e pacotes (Herança abstrata pontilhado)
        // TODO: Criar UniTests
    }
}
