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
        String result = "========================================\n"
                + "Canal " + numero + ": " + nome + "\n"
                + "------------- Programação --------------\n";
        result += programas != null ? listarProgramas() : "Não existe nenhum programa registrado!";
        result += "========================================";
        return result;
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

    public String listarProgramas() {
        String result = "";
        for (Programa programa : programas) {
            if (programa == null) {
                break;
            }
            result += programa.getNome() + "\n";
        }
        return result;
    }

    public String listarProgramas(String diaAlvo) {
        String result = "";
        for (Programa programa : programas) {
            if (programa == null) {
                break;
            }
            for (Horario horario : programa.getHorarios()) { // Warn! Horarios nao pode ser null
                if (diaAlvo == horario.getDiaSemana()) {
                    result += programa.getNome() + "\n";
                    break;
                }
            }
        }
        return result;
    }

    // Outros metodos
    public void favoritarPrograma(Programa programa) {
        programa.setFavorito(true);
        System.out.println(programa.toString());
    }
    
    public void desfavoritarPrograma(Programa programa) {
        programa.setFavorito(false);
        System.out.println(programa.toString());
    }

    public void adicionarPrograma(Programa programa) {
        System.out.println("Funcionalidade ainda não implentada");
    }

    public void removerPrograma(Programa programa) {
        System.out.println("Funcionalidade ainda não implentada");
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

}
