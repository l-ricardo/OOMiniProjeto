package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import view.CampoDados;

public class CampoDadosTest {
    @Test
    public void testisTextoInvalido() {
        // Cria um novo CampoDados com o texto padrão configurado como "Texto padrão"
        CampoDados campo = new CampoDados("Texto padrão", 0, 0);

        // Configura o texto do campo para "". Nesse caso o texto é invalido por se
        // tratar de uma string vazia, logo o método isTextoInvalido deve retornar true
        String textoPreenchidoProibido1 = "";
        campo.setText(textoPreenchidoProibido1);
        assertTrue(campo.isTextoInvalido());

        // Configura o texto do campo para "Texto padrão". Nesse caso o texto é invalido
        // por ser o mesmo texto usado na contrução do campo, logo o método
        // isTextoInvalido deve retornar true
        String textoPreenchidoProibido2 = "Texto padrão";
        campo.setText(textoPreenchidoProibido2);
        assertTrue(campo.isTextoInvalido());

        // Configura o texto do campo para "". Nesse caso o texto é valido por ser
        // diferente do texto usado na contrução do campo e não ser uma string vazia,
        // logo o método isTextoInvalido deve retornar false
        String textoPreenchidoPermitido = "Qualquer outra coisa";
        campo.setText(textoPreenchidoPermitido);
        assertFalse(campo.isTextoInvalido());
    }
}
