package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import models.Canal;
import models.Dados;
import models.Programa;

public class CriaCanal extends JPanel implements ActionListener, FocusListener {
    JTextField caixaNome, caixaNumero;
    JLabel titulo, dicaNome, dicaNumero, dicaPrograma;
    JButton salvar;
    JList<Programa> listaProgramas;
    JScrollPane listaProgramasRolavel;

    Dados d;

    public CriaCanal(Dados dados) {
        d = dados;
        setBounds(0, 200, 800, 600);
        setLayout(null);

        // Componentes
        titulo = new JLabel("Faça o cadastro de um canal");
        titulo.setBounds(50, 10, 700, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));

        dicaNome = new JLabel("Nome:");
        dicaNome.setBounds(50, 70, 300, 30);
        caixaNome = new JTextField("Insira aqui o nome do canal...");
        caixaNome.setBounds(50, 100, 300, 30);
        caixaNome.addFocusListener(this);

        dicaNumero = new JLabel("Número:");
        dicaNumero.setBounds(50, 170, 300, 30);
        caixaNumero = new JTextField("Insira aqui o número do canal...");
        caixaNumero.setBounds(50, 200, 300, 30);
        caixaNumero.addFocusListener(this);

        dicaPrograma = new JLabel("Programação:");
        dicaPrograma.setBounds(400, 70, 300, 30);

        DefaultListModel<Programa> elementos = new DefaultListModel<>();
        for (Programa programa : d.getProgramaTipoJornal()) {
            elementos.addElement(programa);
        }
        for (Programa programa : d.getProgramaTipoNovelaFilmeSerie()) {
            elementos.addElement(programa);
        }
        for (Programa programa : d.getProgramaTipoTalkShow()) {
            elementos.addElement(programa);
        }
        listaProgramas = new JList<>(elementos);
        listaProgramas.setVisible(true);
        listaProgramas.setFont(new Font("Arial", Font.PLAIN, 18));
        listaProgramas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listaProgramasRolavel = new JScrollPane(listaProgramas);
        listaProgramasRolavel.setBounds(400, 100, 300, 300);

        salvar = new JButton("Salvar"); // TODO: Adicionar icone
        salvar.setBounds(50, 370, 150, 30);
        salvar.addActionListener(this);

        // add(titulo);
        add(dicaNome);
        add(caixaNome);
        add(dicaNumero);
        add(caixaNumero);
        add(dicaPrograma);
        add(listaProgramasRolavel);
        add(salvar);
    }

    public CriaCanal(Dados dados, int index) {
        this(dados);
        caixaNome.setText(dados.getCanais().get(index).getNome());
        caixaNumero.setText(String.valueOf(dados.getCanais().get(index).getNumero()));
        for (Programa programa : dados.getCanais().get(index).getProgramas()) {
            listaProgramas.setSelectedIndex(dados.getCanais().get(index).getProgramas().indexOf(programa));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clicado = e.getSource();

        if (clicado == salvar) {
            Canal novoCanal = new Canal(caixaNome.getText(), Integer.parseInt(caixaNumero.getText()));
            // Usa o set para adicionar os selecionados na caixa de selecao listaProgramas
            if (listaProgramas.getSelectedValuesList() != null) {
                novoCanal.setProgramas(listaProgramas.getSelectedValuesList());
            }
            d.getCanais().add(novoCanal);
            // TODO: Evitar que clicando duas vezes em salvar seja feito o cadastro dobrado
            // TODO: Checar se ja existe um canal com o mesmo nome e numero cadastrado
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
