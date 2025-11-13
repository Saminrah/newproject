package MorseKodUppgift;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KodMorseTest {

    @Test
    @DisplayName("Text till morse")
    void textTillMorse_Test() {
        KodMorse konverterare = new KodMorse();
        assertEquals(".... . .-.. .-.. ---", konverterare.tillMorse("hello"), "Korrekt översättning.");
    }

    @Test
    @DisplayName("Text till morse med versaler")
    void textTillMorse_Versaler() {
        KodMorse konverterare = new KodMorse();
        assertEquals("... .- -- .. -.", konverterare.tillMorse("SAMIN"), "Korrekt översättning.");
    }

    @Test
    @DisplayName("Morse till text")
    void morseTillText_Test() {
        KodMorse konverterare = new KodMorse();
        assertEquals("KURS", konverterare.tillText("-.- ..- .-. ..."), "Korrekt översättning.");
    }

    @Test
    @DisplayName("Ogiltigt tecken i text")
    void textTillMorse_OgiltigtTecken() {
        KodMorse konverterare = new KodMorse();
        Exception undantag = assertThrows(IllegalArgumentException.class, () -> {
            konverterare.tillMorse("TESTAR2");
        });
        assertTrue(undantag.getMessage().contains("Tecknet '2' är inte giltigt i detta program."), "Felmeddelande ska visas.");
    }

    @Test
    @DisplayName("Ogiltig morsekod")
    void morseTillText_OgiltigKod() {
        KodMorse konverterare = new KodMorse();
        Exception undantag = assertThrows(IllegalArgumentException.class, () -> {
            konverterare.tillText("......-.");
        });
        assertTrue(undantag.getMessage().contains("Koden '......-.' är inte giltig i detta program."), "Felmeddelande ska visas.");
    }
}
