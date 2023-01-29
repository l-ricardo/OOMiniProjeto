package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Canal;
import model.Dados;

public class FiltroCanalTest {

    @Test
    public void testGetCanal() {
        // Inicializa os um novo banco de dados
        Dados dadosTeste = new Dados();

        // Adiciona dois novos canais ao banco de dados
        dadosTeste.getCanais().add(new Canal("Canal Teste", 25));
        dadosTeste.getCanais().add(new Canal("Canal", 26));

        // Cria um novo objeto do tipo Canal ao qual se espera receber
        // do getCanal(String nome)
        Canal canalEsperado = new Canal("Canal Teste", 25);

        // Nesse caso o filtro colocado para o metodo getCanal foi igual ao nome do
        // canal esperado logo esperamos que o canal encontrado tenha os mesmos
        // atributos do canal esperado.
        Canal canalEncontrado1 = dadosTeste.getCanal("Canal Teste");
        assertEquals(canalEncontrado1.getNome(), canalEsperado.getNome());
        assertEquals(canalEncontrado1.getNumero(), canalEsperado.getNumero());
        assertEquals(canalEncontrado1.getProgramas(), canalEsperado.getProgramas());

        // Nesse caso o filtro colocado para o metodo getCanal foi o nome de um canal já
        // existente no banco de dados, esperamos que os atributos do canal encontrado
        // sejam diferentes dos atributos do canal esperado.
        Canal canalEncontrado2 = dadosTeste.getCanal("Globo");
        assertNotEquals(canalEncontrado2.getNome(), canalEsperado.getNome());
        assertNotEquals(canalEncontrado2.getNumero(), canalEsperado.getNumero());
        assertNotEquals(canalEncontrado2.getProgramas(), canalEsperado.getProgramas());

        // Nesse caso o filtro colocado para o metodo getCanal foi o nome de um canal
        // que não existe no banco de dados e nem foi cadastrado no comeco desse teste,
        // logo o retorno do metodo getCanal deve ser null
        Canal canalEncontrado3 = dadosTeste.getCanal("Canal Inexistente");
        assertNull(canalEncontrado3);
    }
}
