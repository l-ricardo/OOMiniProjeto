# Gerenciador de programação da TV aberta

Esse é um mini projeto para a disciplina de Orientação à Objetos, cursado na Universidade de Brasília. 

O projeto em questão cria um software de gerenciamento da Programação da TV aberta, seguindo a estrutura de classes desse [diagrama UML](DiagramaClasses.png) e implementando as seguintes funcionalidades: 
- CRUD de canal
- CRUD de programa
- Listagem da programação de um canal em um determinado dia
- Busca por um programa específico

## Desenvolvido por:
| Matrícula | Nome | Nick no GitHub |
|-----------|------|------------------|
| 221007653 | Luciano Ricardo da Silva Júnior | l-ricardo |

## Navegando pelo projeto:

[Teste](src\controle\Teste.java) é onde fica o metodo main e são feitos os testes da primeira entrega do MiniProjeto.

[Dados](src\modelos\Dados.java) inicializa alguns dados para facilitar o uso do Teste.java.

[Pessoa](src\modelos\Pessoa.java) é uma classe que modela uma pessoa.

[Artista](src\modelos\Artista.java) é uma classe que herda de pessoa e modela uma pessoa não fictícia seja ela apresentadora, jornalista, musica, etc...

[Personagem](src\modelos\Personagem.java) é uma classe que herda de pessoa e modela um personagem fictício de um programa de uma serie, novela, filme, animação, etc...

[Canal](src\modelos\Canal.java) é uma classe que modela um canal de tv.

[Horario](src\modelos\Horario.java) é uma classe que modela um unico horario de um programa.

[Programa](src\modelos\Programa.java) é uma classe abstrata que modela um programa.

[NovelaFilmeSerie](src\modelos\NovelaFilmeSerie.java) é uma classe que herda de programa e modela uma serie, novela, filme, animação, etc...

[TalkShow](src\modelos\TalkShow.java) é uma classe que herda de programa e modela um programa de entrevista ou entreterimento no geral.

[Jornal](src\modelos\Jornal.java) é uma classe que herda de programa e modela um noticiário.
