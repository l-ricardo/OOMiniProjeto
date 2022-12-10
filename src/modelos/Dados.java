package modelos;

public class Dados { // Doubt? Preciso de declarar o tamanho dos Arrays aqui?
    private Canal[] canais = new Canal[10];
    private Horario[] horarios = new Horario[24 * 7 + 100];
    private Artista[] artistas = new Artista[50];
    private Personagem[] personagens = new Personagem[50];
    private TalkShowJornal[] programaTipoTalkShowJornal = new TalkShowJornal[100];
    private NovelaFilmeSerie[] programaTipoNovelaFilmeSerie = new NovelaFilmeSerie[100];

    // Criando valores de exemplo
    {
        canais[0] = new Canal("Globo", 8);
        canais[1] = new Canal("Record", 10);
        canais[2] = new Canal("SBT", 2);

        for (int i = 0; i < 24; i++) {
            horarios[i] = new Horario(i, i + 1, "Domingo");
        }
        for (int i = 24; i < 48; i++) {
            horarios[i] = new Horario(i - 24, i - 24 + 1, "Segunda");
        }
        for (int i = 48; i < 72; i++) {
            horarios[i] = new Horario(i - 48, i - 48 + 1, "Terça");
        }
        for (int i = 72; i < 96; i++) {
            horarios[i] = new Horario(i - 72, i - 72 + 1, "Quarta");
        }
        for (int i = 96; i < 120; i++) {
            horarios[i] = new Horario(i - 96, i - 96 + 1, "Quinta");
        }
        for (int i = 120; i < 144; i++) {
            horarios[i] = new Horario(i - 120, i - 120 + 1, "Sexta");
        }
        for (int i = 144; i < 168; i++) {
            horarios[i] = new Horario(i - 144, i - 144 + 1, "Sabado");
        }

        artistas[0] = new Artista("Ana Maria Braga", 'F');
        artistas[1] = new Artista("Louro Mané", 'M', "Humorista");
        artistas[2] = new Artista("Rodrigo Faro", 'M');
        artistas[3] = new Artista("Silvio Santos", 'M');
        artistas[4] = new Artista("Marcos Mion", 'M');
        artistas[5] = new Artista("William Boner", 'M', "Jornalista");
        artistas[6] = new Artista("Renata Vasconcelos", 'F', "Jornalista");
        personagens[0] = new Personagem("Carminha", 'F', "Adriana Esteves");
        personagens[1] = new Personagem("Tufão", 'M', "Murilo Benicio");
        personagens[2] = new Personagem("Nina/Rita", 'F', "Debora Falabella");

        programaTipoTalkShowJornal[0] = new TalkShowJornal("Mais Você", canais[0]);
        programaTipoTalkShowJornal[1] = new TalkShowJornal("Hora do Faro", canais[1]);
        programaTipoTalkShowJornal[2] = new TalkShowJornal("Programa do Silvio Santos", canais[2]);
        programaTipoTalkShowJornal[3] = new TalkShowJornal("Roda Roda Jequiti", canais[2]);
        programaTipoTalkShowJornal[4] = new TalkShowJornal("Caldeirao", canais[0]);
        programaTipoTalkShowJornal[5] = new TalkShowJornal("Jornal Nacional",
                new Horario[] { horarios[0], horarios[24], horarios[34], horarios[48], horarios[51] },
                canais[0],
                new Artista[] { artistas[5], artistas[6] });

        programaTipoNovelaFilmeSerie[0] = new NovelaFilmeSerie("Avenida Brasil", canais[0]);

        programaTipoTalkShowJornal[0].setArtistas(artistas[0], artistas[1]);
        programaTipoTalkShowJornal[1].setArtistas(artistas[2]);
        programaTipoTalkShowJornal[2].setArtistas(artistas[4]);
        programaTipoTalkShowJornal[3].setArtistas(artistas[3]);
        programaTipoTalkShowJornal[4].setArtistas(artistas[3]);

        programaTipoNovelaFilmeSerie[0].setPersonagens(personagens[0], personagens[1], personagens[2]);

        programaTipoTalkShowJornal[0].setHorarios(horarios[7], horarios[14], horarios[31], horarios[50]);
        programaTipoTalkShowJornal[1].setHorarios(horarios[2], horarios[10], horarios[40], horarios[50]);
        programaTipoTalkShowJornal[2].setHorarios(horarios[44], horarios[51], horarios[85], horarios[60]);
        programaTipoTalkShowJornal[3].setHorarios(horarios[19], horarios[90], horarios[0], horarios[50]);
        programaTipoTalkShowJornal[4].setHorarios(horarios[21], horarios[14], horarios[3]);

        programaTipoNovelaFilmeSerie[0].setHorarios(horarios[5], horarios[15], horarios[20], horarios[25]);
    }

    // Metodos Obrigatorios
    public void pesquisarPrograma(String programaAlvo) {
        for (TalkShowJornal programa : programaTipoTalkShowJornal) {
            if (programa == null) {
                break;
            }
            if (programa.getNome() == programaAlvo) {
                System.out.println(programa.toString());
            }
        }
        for (NovelaFilmeSerie programa : programaTipoNovelaFilmeSerie) {
            if (programa == null) {
                break;
            }
            if (programa.getNome() == programaAlvo) {
                System.out.println(programa.toString());
            }
        }
    }

    public void listarProgramas(String canalAlvo, String diaAlvo) { 
        for (TalkShowJornal programa : programaTipoTalkShowJornal) {
            if (programa == null) {
                break;
            }
            if (programa.getCanal().getNome() == canalAlvo) {
                for (Horario horario : programa.getHorarios()) {
                    if (horario.getDiaSemana() == diaAlvo) {
                        System.out.println(programa.toString());
                        break; // Evita listagem duplicada de canais exibidos duas vezes no mesmo dia
                    }
                }
            }
        }
        for (NovelaFilmeSerie programa : programaTipoNovelaFilmeSerie) {
            if (programa == null) {
                break;
            }
            if (programa.getCanal().getNome() == canalAlvo) {
                for (Horario horario : programa.getHorarios()) {
                    if (horario.getDiaSemana() == diaAlvo) {
                        System.out.println(programa.toString());
                        break; // Evita listagem duplicada de canais exibidos duas vezes no mesmo dia
                    }
                }
            }
        }
    }

    // Gets e Sets
    public Canal[] getCanais() {
        return canais;
    }

    public void setCanais(Canal[] canais) {
        this.canais = canais;
    }

    public Horario[] getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario[] horarios) {
        this.horarios = horarios;
    }

    public Artista[] getArtistas() {
        return artistas;
    }

    public void setArtistas(Artista[] artistas) {
        this.artistas = artistas;
    }

    public Personagem[] getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Personagem[] personagens) {
        this.personagens = personagens;
    }

    public TalkShowJornal[] getProgramaTipoTalkShowJornal() {
        return programaTipoTalkShowJornal;
    }

    public void setProgramaTipoTalkShowJornal(TalkShowJornal[] programaTipoTalkShowJornal) {
        this.programaTipoTalkShowJornal = programaTipoTalkShowJornal;
    }

    public NovelaFilmeSerie[] getProgramaTipoNovelaFilmeSerie() {
        return programaTipoNovelaFilmeSerie;
    }

    public void setProgramaTipoNovelaFilmeSerie(NovelaFilmeSerie[] programaTipoNovelaFilmeSerie) {
        this.programaTipoNovelaFilmeSerie = programaTipoNovelaFilmeSerie;
    }

}