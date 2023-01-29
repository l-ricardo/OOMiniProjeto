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

    @Test
    public void testisNumeroInvalido() {
        // Cria um novo CampoDados com o numero padrão configurado como "Texto padrão"
        CampoDados campo = new CampoDados("Texto padrão", 0, 0);

        // Configura o numero do campo para "". Nesse caso o numero é invalido por se
        // tratar de uma string vazia, logo o método isNumeroInvalido deve retornar true
        String numeroPreenchidoProibido1 = " ";
        campo.setText(numeroPreenchidoProibido1);
        assertTrue(campo.isNumeroInvalido());

        // Configura o numero do campo para "aaaaaaa". Nesse caso o numero é invalido
        // por se tratar de uma string com letras, logo o método isNumeroInvalido deve
        // retornar true
        String numeroPreenchidoProibido2 = "aaaaaaa";
        campo.setText(numeroPreenchidoProibido2);
        assertTrue(campo.isNumeroInvalido());

        // Configura o numero do campo para "0123456789a". Nesse caso o numero é
        // invalido por se tratar de uma string com letras, logo o método
        // isNumeroInvalido deve retornar true
        String numeroPreenchidoProibido3 = "0123456789a";
        campo.setText(numeroPreenchidoProibido3);
        assertTrue(campo.isNumeroInvalido());

        // Configura o numero do campo para "0123456789". Nesse caso o numero é valido
        // por ser apenas numeros, logo o método isNumeroInvalido deve retornar false
        String numeroPreenchidoPermitido = "0123456789";
        campo.setText(numeroPreenchidoPermitido);
        assertFalse(campo.isNumeroInvalido());
    }

    @Test
    public void testisHorarioInvalido() {
        // Cria um novo CampoDados com o horario padrão configurado como "Texto padrão"
        CampoDados campo = new CampoDados("Texto padrão", 0, 0);

        // Configura o horario do campo para "". Nesse caso o horario é invalido por se
        // tratar de uma string vazia, logo o método isHorarioInvalido deve retornar
        // true
        String horarioPreenchidoProibido1 = " ";
        campo.setText(horarioPreenchidoProibido1);
        assertTrue(campo.isHorarioInvalido());

        // Configura o horario do campo para "aaaaaaa". Nesse caso o horario é invalido
        // por se tratar de uma string com letras, logo o método isHorarioInvalido deve
        // retornar true
        String horarioPreenchidoProibido2 = "aaaaaaa";
        campo.setText(horarioPreenchidoProibido2);
        assertTrue(campo.isHorarioInvalido());

        // Configura o horario do campo para "25:61". Nesse caso o horario é
        // invalido por se tratar de um horario inexistente logo o método
        // isHorarioInvalido deve retornar true
        String horarioPreenchidoProibido3 = "25:61";
        campo.setText(horarioPreenchidoProibido3);
        assertTrue(campo.isHorarioInvalido());

        // Configura o horario do campo para "4h25min". Nesse caso o horario é
        // invalido por se tratar de um horario que nao obedece o formato HH:MM logo o
        // método isHorarioInvalido deve retornar true
        String horarioPreenchidoProibido4 = "4h25min";
        campo.setText(horarioPreenchidoProibido4);
        assertTrue(campo.isHorarioInvalido());

        // Configura o horario do campo para "12:30:10". Nesse caso o horario é
        // invalido por se tratar de um horario com segundos logo o método
        // isHorarioInvalido deve retornar true
        String horarioPreenchidoProibido5 = "12:30:10";
        campo.setText(horarioPreenchidoProibido5);
        assertTrue(campo.isHorarioInvalido());

        // Configura o horario do campo para "12:30". Nesse caso o horario é
        // valido por se tratar de um horario que obedece o formato HH:MM logo o
        // método isHorarioInvalido deve retornar false
        String horarioPreenchidoPermitido1 = "12:30";
        campo.setText(horarioPreenchidoPermitido1);
        assertFalse(campo.isHorarioInvalido());

        // Configura o horario do campo para "4:25". Nesse caso o horario é
        // valido por se tratar de um horario que obedece o formato HH:MM logo o
        // método isHorarioInvalido deve retornar false
        String horarioPreenchidoPermitido2 = "4:25";
        campo.setText(horarioPreenchidoPermitido2);
        assertFalse(campo.isHorarioInvalido());
    }
}
