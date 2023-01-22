package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelos.Canal;
import modelos.Dados;

public class CriaCanal extends JPanel implements ActionListener {

    JTextField caixaNome, caixaNumero, caixaPrograma;
    JLabel titulo, dicaNome, dicaNumero, dicaPrograma;
    JButton salvar, cancelar;
    Dados d;


    public CriaCanal(Dados dados) {
        d = dados;
        setBounds(0, 200, 800, 600);
        setLayout(null);

        
        // Componentes
        titulo = new JLabel("Faça o cadastro de um canal");
        titulo.setBounds(50, 10, 300, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        dicaNome = new JLabel("Nome:");
        dicaNome.setBounds(50, 70, 300, 30);
        caixaNome = new JTextField("Insira aqui o nome do canal...");
        caixaNome.setBounds(50, 100, 300, 30);

        dicaNumero = new JLabel("Número:");
        dicaNumero.setBounds(50, 170, 300, 30);
        caixaNumero = new JTextField("Insira aqui o número do canal...");
        caixaNumero.setBounds(50, 200, 300, 30);

        dicaPrograma = new JLabel("Programação:");
        dicaPrograma.setBounds(50, 270, 300, 30);
        caixaPrograma = new JTextField("Selecione os programas que esse canal exibe...");
        caixaPrograma.setBounds(50, 300, 300, 30);

        salvar = new JButton("Salvar"); // TODO: Adicionar icone
        salvar.setBounds(50, 370, 150, 30);
        salvar.addActionListener(this);

        // cancelar = new JButton("Cancelar"); // TODO: Adicionar icone
        // cancelar.setBounds(200, 370, 150, 30);
        // cancelar.addActionListener(this);

        add(titulo);
        add(dicaNome);
        add(caixaNome);
        add(dicaNumero);
        add(caixaNumero);
        add(dicaPrograma);
        add(caixaPrograma);
        add(salvar);
        // add(cancelar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object clicado = ae.getSource();

        if (clicado == salvar) {
            Canal novoCanal = new Canal(caixaNome.getText(),
                    Integer.parseInt(caixaNumero.getText()));
            // TODO: Fazer caso de adidionar opcionalmente programas
            d.getCanais().add(novoCanal);
            // titulo.setText("Voce salvou esse canal");
            // System.out.println("_____________________foi feito_____________________________");
            // System.out.println(d.getCanais().toString());
            // TODO: Voltar para tela anterior ou limpar todos os campos
            // TODO: Evitar que clicando duas vezes em salvar seja feito o cadastro dobrado
        }
        // if (clicado == cancelar) {
        //     titulo.setText("Voce cancelou");
        //     // TODO: Voltar para tela anterior
        // }
    }
}


