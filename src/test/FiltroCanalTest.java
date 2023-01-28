package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Canal;
import model.Dados;

public class FiltroCanalTest {

    @Test
    public void testGetCanal() {
        Dados d = new Dados();

        Canal canalEsperado = new Canal("Globo", 8);
        Canal canalRecebido = d.getCanal("Globo");

        assertEquals(canalEsperado, canalRecebido);
    }
}
