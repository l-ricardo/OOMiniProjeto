# Gerenciador de programação da TV aberta

Esse é um mini projeto para a disciplina de Orientação à Objetos, cursado na Universidade de Brasília. 
O projeto em questão cria um software de gerenciamento de Programação da TV aberta que contem as seguintes funcionalidades: 
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

[Dados](src\modelos\Dados.java) inicializa alguns dados e hospeda os métodos de controle dos dados.

[Pessoa](src\modelos\Pessoa.java) é uma classe abstrata que modela uma pessoa.

[Apresentador](src\modelos\Apresentador.java) é uma classe que herda de pessoa e modela um apresentador de um programa de entrevista, jornal, etc...

[Personagem](src\modelos\Personagem.java) é uma classe que herda de pessoa e modela um personagem de um programa de uma serie, novela, filme, animação, etc...

[Canal](src\modelos\Canal.java) é uma classe que modela um canal de tv.

[Horario](src\modelos\Horario.java) é uma classe que modela um unico horario de um programa.

[Programa](src\modelos\Programa.java) é uma classe que modela o programa (contendo um canal e um ou mais horarios).

[NovelaFilmeSerie](src\modelos\NovelaFilmeSerie.java) é uma classe que herda de programa e modela uma serie, novela, filme, animação, etc...

[TalkShowJornal](src\modelos\TalkShowJornal.java) é uma classe que herda de programa e modela um programa de entrevista, jornal, etc...

