package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.*;

import models.Canal;
import models.Dados;
import models.Programa;

public class CriaCanal extends JPanel implements ActionListener, FocusListener {
    Dados d;
    int indexCanalSelecionado;

    JTextField caixaNome, caixaNumero;
    JLabel dicaNome, dicaNumero, dicaPrograma;
    JButton salvar, atualizar;
    JList<Programa> listaProgramas;
    JScrollPane listaProgramasRolavel;

    public CriaCanal(Dados dados) {
        d = dados;
        setBounds(0, 200, 800, 600);
        setLayout(null);

        // Componentes
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

        dicaPrograma = new JLabel("Programação: (Use 'Ctrl' para selecionar multiplos)");
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
        // DOUBT? O objetivo dessa linha era remover a necessidade de utilizar 'Ctrl'
        // mas nao funciona
        listaProgramas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listaProgramas.setFont(new Font("Arial", Font.PLAIN, 18));
        listaProgramas.setVisible(true);
        listaProgramasRolavel = new JScrollPane(listaProgramas);
        listaProgramasRolavel.setBounds(400, 100, 300, 300);
        listaProgramasRolavel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        salvar = new JButton("Salvar"); // TODO: Adicionar icone
        salvar.setBounds(50, 370, 150, 30);
        salvar.addActionListener(this);

        add(dicaNome);
        add(caixaNome);
        add(dicaNumero);
        add(caixaNumero);
        add(dicaPrograma);
        add(listaProgramasRolavel);
        add(salvar);
    }

    // Nesse caso o canal ja existe e estamos no modo de edicao
    public CriaCanal(Dados dados, int index) {
        this(dados);
        indexCanalSelecionado = index;
        caixaNome.setText(dados.getCanais().get(index).getNome());
        caixaNumero.setText(String.valueOf(dados.getCanais().get(index).getNumero()));
        for (Programa programa : dados.getCanais().get(index).getProgramas()) {
            listaProgramas.setSelectedIndex(dados.getCanais().get(index).getProgramas().indexOf(programa));
        }
        salvar.setVisible(false);
        atualizar = new JButton("Atualizar"); // TODO: Adicionar icone
        atualizar.setBounds(50, 370, 150, 30);
        atualizar.addActionListener(this);
        add(atualizar);
        this.updateUI();

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
        if (clicado == atualizar) {
            Canal novoCanal = new Canal(caixaNome.getText(), Integer.parseInt(caixaNumero.getText()));
            // Usa o set para adicionar os selecionados na caixa de selecao listaProgramas
            if (listaProgramas.getSelectedValuesList() != null) {
                novoCanal.setProgramas(listaProgramas.getSelectedValuesList());
            }
            d.getCanais().set(indexCanalSelecionado, novoCanal);
            // TODO: Fechar o Jdialog aqui
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
