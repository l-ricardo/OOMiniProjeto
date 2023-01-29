# Gerenciador de programação da TV aberta

Esse é um mini projeto para a disciplina de Orientação à Objetos, cursado na Universidade de Brasília. 

O projeto em questão cria um software de gerenciamento da Programação da TV aberta, seguindo a estrutura do [diagrama de classes](DiagramaClasses.png) e do o [diagrama de pacotes](DiagramaPacotes.png) e implementando as seguintes funcionalidades: 
- CRUD de canal
- CRUD de programa
- Listagem da programação de um canal em um determinado dia
- Busca por um programa específico

## Desenvolvido por:
| Matrícula | Nome | Nick no GitHub |
|-----------|------|------------------|
| 221007653 | Luciano Ricardo da Silva Júnior | l-ricardo |

## Navegando pelo projeto:

### Pacote model
[Dados](src\model\Dados.java) simula um banco de dados e também inicializa alguns dados para melhor demontração do projeto.

[Canal](src\model\Canal.java) é uma classe que modela um canal de tv.

[Pessoa](src\model\Pessoa.java) é uma classe que modela uma pessoa.

[Artista](src\model\Artista.java) é uma classe que herda de pessoa e modela uma pessoa não fictícia seja ela apresentadora, jornalista, musica, etc...

[Personagem](src\model\Personagem.java) é uma classe que herda de pessoa e modela um personagem fictício de um programa de uma serie, novela, filme, animação, etc...

[Programa](src\model\Programa.java) é uma classe abstrata que modela um programa.

[NovelaFilmeSerie](src\model\NovelaFilmeSerie.java) é uma classe que herda de programa e modela uma serie, novela, filme, animação, etc...

[TalkShow](src\model\TalkShow.java) é uma classe que herda de programa e modela um programa de entrevista ou entreterimento no geral.

[Jornal](src\model\Jornal.java) é uma classe que herda de programa e modela um noticiário.

### Pacote view
[App](src\view\App.java) é a principal da aplicação, além de possuir o metodo main ela possui os botões principais e também os containers onde serão instanciados as outras telas.

[TelaDetalheCanal](src\view\TelaDetalheCanal.java), [TelaDetalhePrograma](src\view\TelaDetalhePrograma.java) e [TelaDetalhePessoa](src\view\TelaDetalhePessoa.java) são as telas de cadastro e edição de Canal, Programa e Pessoa, respectivamente.

[TelaListaCanais](src\view\TelaListaCanais.java), [TelaListaProgramas](src\view\TelaListaProgramas.java) e [TelaListaPessoas](src\view\TelaListaPessoas.java) são as telas de listagem de Canais, Programas e Pessoas, respectivamente.

Já [BotaoPequeno](src\view\BotaoPequeno.java), [BotaoGrande](src\view\BotaoGrande.java), [BotaoRadialCustomizado](src\view\BotaoRadialCustomizado.java), [CheckBoxCustomizada](src\view\CheckBoxCustomizada.java), [CampoFiltragem](src\view\CampoFiltragem.java) e [CampoDados](src\view\CampoDados.java)  são componentes usados repetitivamente por toda a aplicação.

## Funcionalidades:
- CRUD de canal
- CRUD de programa
- RD de pessoa
- Listagem da programação de um canal em um determinado dia (Basta digitar o nome do canal no campo de filtragem de canais, selecionar pelo menos um dia e clicar em listar programas)
- Busca por um programa específico (Basta digitar o nome no campo de filtragem de programas e clicar em listar programas)
- Busca por um canal específico (Basta digitar o nome no campo de filtragem de canais e clicar em listar canais)
- Busca por uma pessoa específica (Basta digitar o nome no campo de filtragem de pessoas e clicar em listar pessoas)

## Documentação (javadoc):
Disponivel [aqui](docs\index-all.html).

Pode ser gerado executando o comando:
`javadoc src\model\*.java src\view\*.java -d docs`

## Testes unitarios:
Disponivel [aqui](src\test).

Pode ser executado com o comando:
`java -cp classpath org.junit.platform.launcher.core.Launcher src\test\Testes.java`