package modelos;

public class Canal {
    private String nome;
    private int numero;
    private Programa[] programas;

    // Construtores
    public Canal(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public Canal(String nome, int numero, Programa... programas) {
        this(nome, numero);
        this.programas = programas;
    }

    @Override
    public String toString() {
        return "Canal " + numero + ": " + nome;
    }

    // Gets e Sets
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Programa[] getProgramas() {
        return programas;
    }

    public void setProgramas(Programa... programas) {
        this.programas = programas;
    }

    // Metodos Obrigatorios
    public void pesquisarPrograma(String nomeProgramaAlvo) {
        for (Programa programa : programas) {
            if (programa == null) {
                break;
            }
            if (programa.getNome() == nomeProgramaAlvo) {
                System.out.println(programa.toString());
            }
        }
    }

    // public void listarProgramas(String canalAlvo, String diaAlvo) { // ToDo:
    // Readaptar para o uso do Calendar
    // for (TalkShowJornal programa : programaTipoTalkShowJornal) {
    // if (programa == null) {
    // break;
    // }
    // if (programa.getCanal().getNome() == canalAlvo) {
    // for (Horario horario : programa.getHorarios()) {
    // if (horario.getDiaSemana() == diaAlvo) {
    // System.out.println(programa.toString());
    // break; // Evita listagem duplicada de canais exibidos duas vezes no mesmo dia
    // }
    // }
    // }
    // }
    // for (NovelaFilmeSerie programa : programaTipoNovelaFilmeSerie) {
    // if (programa == null) {
    // break;
    // }
    // if (programa.getCanal().getNome() == canalAlvo) {
    // for (Horario horario : programa.getHorarios()) {
    // if (horario.getDiaSemana() == diaAlvo) {
    // System.out.println(programa.toString());
    // break; // Evita listagem duplicada de canais exibidos duas vezes no mesmo dia
    // }
    // }
    // }
    // }
    // }

    // Outros metodos
    public void adicionarPrograma() {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerPrograma() {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void favoritarPrograma() {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void desfavoritarPrograma() {
        System.out.println("Funcionalidade ainda não implentada");
    }
}