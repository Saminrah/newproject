package MorseKodUppgift;

import java.util.HashMap;

public class KodMorse {

    HashMap<String, Character> morseTillText = new HashMap<>(); // nyckel = morsekod, värde = bokstav
    HashMap<Character, String> textTillMorse = new HashMap<>(); // nyckel = bokstav, värde = morsekod

    public KodMorse() {
        // hashmaps med bokstäver och morsekod

        textTillMorse.put('A', ".-");   morseTillText.put(".-", 'A');
        textTillMorse.put('B', "-..."); morseTillText.put("-...", 'B');
        textTillMorse.put('C', "-.-."); morseTillText.put("-.-.", 'C');
        textTillMorse.put('D', "-..");  morseTillText.put("-..", 'D');
        textTillMorse.put('E', ".");    morseTillText.put(".", 'E');
        textTillMorse.put('F', "..-."); morseTillText.put("..-.", 'F');
        textTillMorse.put('G', "--.");  morseTillText.put("--.", 'G');
        textTillMorse.put('H', "...."); morseTillText.put("....", 'H');
        textTillMorse.put('I', "..");   morseTillText.put("..", 'I');
        textTillMorse.put('J', ".---"); morseTillText.put(".---", 'J');
        textTillMorse.put('K', "-.-");  morseTillText.put("-.-", 'K');
        textTillMorse.put('L', ".-.."); morseTillText.put(".-..", 'L');
        textTillMorse.put('M', "--");   morseTillText.put("--", 'M');
        textTillMorse.put('N', "-.");   morseTillText.put("-.", 'N');
        textTillMorse.put('O', "---");  morseTillText.put("---", 'O');
        textTillMorse.put('P', ".--."); morseTillText.put(".--.", 'P');
        textTillMorse.put('Q', "--.-"); morseTillText.put("--.-", 'Q');
        textTillMorse.put('R', ".-.");  morseTillText.put(".-.", 'R');
        textTillMorse.put('S', "...");  morseTillText.put("...", 'S');
        textTillMorse.put('T', "-");    morseTillText.put("-", 'T');
        textTillMorse.put('U', "..-");  morseTillText.put("..-", 'U');
        textTillMorse.put('V', "...-"); morseTillText.put("...-", 'V');
        textTillMorse.put('W', ".--");  morseTillText.put(".--", 'W');
        textTillMorse.put('X', "-..-"); morseTillText.put("-..-", 'X');
        textTillMorse.put('Y', "-.--"); morseTillText.put("-.--", 'Y');
        textTillMorse.put('Z', "--.."); morseTillText.put("--..", 'Z');
    }

    // metod som omvandlar text till morsekod
    public String tillMorse(String inmatadText) {
        inmatadText = inmatadText.toUpperCase(); // gör om till versaler för att matcha nycklarna
        String resultat = ""; // lagrar den färdiga morsekoden

        // loopar igenom varje tecken i texten
        for (char tecken : inmatadText.toCharArray()) {
            if (tecken == ' ') { // mellanrum i text blir mellanrum i morsekoden
                resultat = resultat.concat(" ");
            } else if (textTillMorse.containsKey(tecken)) { // om tecknet finns i vår hashmap
                resultat = resultat.concat(textTillMorse.get(tecken) + " ");
            } else { // ogiltigt tecken
                throw new IllegalArgumentException("Tecknet '" + tecken + "' är inte giltigt i detta program.");
            }
        }

        // tar bort det extra blanksteg
        resultat = resultat.trim();

        return resultat;
    }

    // metod som omvandlar morsekod till text
    public String tillText(String morsekod) {
        String[] symboler = morsekod.split(" "); // delar upp morsekoden vid varje mellanslag
        String resultat = ""; // lagrar den färdiga texten

        for (String kod : symboler) {
            if (kod.isEmpty()) { // hanterar extra mellanslag
                resultat = resultat.concat(" ");
            } else if (morseTillText.containsKey(kod)) { // giltig morsekod
                resultat = resultat.concat(String.valueOf(morseTillText.get(kod)));
            } else { // ogiltig kod
                throw new IllegalArgumentException("Koden '" + kod + "' är inte giltig i detta program.");
            }
        }
        return resultat;
    }
}
