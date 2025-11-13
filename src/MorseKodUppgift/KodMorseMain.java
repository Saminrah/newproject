package MorseKodUppgift;

import java.util.Scanner;

public class KodMorseMain {
    public static void main(String[] args) {

        try (Scanner inmatning = new Scanner(System.in)) { // används för att läsa användarens inmatning
            KodMorse translator = new KodMorse(); // skapar ett objekt av klassen KodMorse

            // instruktioner till användaren
            System.out.println("Denna program som översätter till och från morsekod.");
            System.out.println("Detta är ett program som översätter till och från morsekod.");
            System.out.println("-- Här Är Dina Val: --");
            System.out.println("1: Översätt text till morse.");
            System.out.println("2: Översätt morse till text.");
            System.out.print("Ange 1 eller 2: ");

            int val = Integer.parseInt(inmatning.nextLine()); // läser in användarens val

            if (val == 1) {
                System.out.print("Skriv in din text: ");
                String text = inmatning.nextLine();
                System.out.println("Översättning: " + translator.tillMorse(text));

            } else if (val == 2) {
                System.out.print("Skriv in morsekod: ");
                String kod = inmatning.nextLine();
                System.out.println("Översättning: " + translator.tillText(kod));

            } else {
                System.out.println("FELMEDDELANDE: Giltiga val är 1 eller 2.");
            }

        } catch (NumberFormatException e) {
            System.out.println("FELMEDDELANDE: Giltiga val är 1 eller 2.");

        } catch (IllegalArgumentException e) {
            System.out.println("FELMEDDELANDE: " + e.getMessage());
        }
    }
}
