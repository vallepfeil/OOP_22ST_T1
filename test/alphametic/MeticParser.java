//3

package alphametic;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse MeticParser
 * Generell:
 * * Bzgl. ParseException: Generelle Form, String + Int, Man übergibt meistens Fehlerbeschreibung, Buchstabe angeben
 * * als Int-Wert, Fehlerlog als Hilfe
 * * In der ersten For-Schleife: Fehlersuche + Neuer String (SB) mit erlaubten Buchstaben, Call via sb.toString()
 * *
 * * @return
 * * @throws alphametic.ParseException
 * Teil 1:
 * * Teil 1: Fehlersuche + Neuer String, siehe oben. (StringBuilder)
 * String ns:
 * * Normierter, neuer String - überführt aus sb
 * <p>
 * * Teil 2: Metic konstruieren
 * * Operator Ops: Operator finden
 * * String Liste erstellen
 * <p>
 * * Operator finden:
 * * Ops ungleich null musste vorne hin, weil im zweiten Teil der Bedingung (UND) der Namensgeber
 * * Ops noch null sein könnte, damit gibt es noch kein Objekt. Wenn es noch kein Objekt gibt, gibt es auch
 * * keine aufrufbare .equals-Methode!
 * <p>
 * * String Liste words erstellen:
 * * Buchstaben werden eingelesen, wenn Symbol kommt => Word in Liste überführen
 * * Filtern der Symbole
 * * String in Liste überführen
 * * Wort in Operator
 * * LSG-Wort kommt nach =
 * <p>
 * * Wiederverwenden sb, neues Objekt vom Typ StringBuilder
 * <p>
 * Innerhalb der Schleife danach:
 * * Wenn Operator-Symbol (Trennungssymbol), dann Abschnitt Wort
 * * ls = String für die Liste
 * * In der Schleife wird im Else-Fall der Buchstabe an den StringBuilder übergeben, intern wird
 * * das Wort gebildet
 * * Das Wort in die Liste eingefügt
 * * Dann fängt er wieder mit einem neuen Wort an
 * Metic m = new Metic(ops, words); return m; abkürzbar in return new Metic(ops, words);
 */

public class MeticParser {
    public static Metic run(String input) throws ParseException {
        int c = 0; StringBuilder sb = new StringBuilder(); for (char buchstabe : input.toCharArray()) {
            if (buchstabe == '+' || buchstabe == '-' || buchstabe == '*' || buchstabe == '=' || Character.isWhitespace(buchstabe) || buchstabe == Character.LINE_SEPARATOR || Character.isLetter(buchstabe)) {
                if (buchstabe == '=') {
                    c++;
                } if (Character.isUpperCase(buchstabe)) {
                    sb.append(Character.toLowerCase(buchstabe));
                }
                else sb.append(buchstabe);
            }
            else throw new ParseException("Unerlaubtes Symbol", 0);
        } if (c != 1) {
            throw new ParseException("Unerlaubte Lösung", 404);
        }

        String ns = sb.toString();

        Operator ops = null; for (char buchstabe : ns.toCharArray()) {
            switch (buchstabe) {
                case '+' -> {
                    if (ops != null && !ops.equals(new Plus())) {
                        throw new ParseException("Error", 0);
                    } ops = new Plus();
                } case '-' -> {
                    if (ops != null && !ops.equals(new Minus())) {
                        throw new ParseException("Error", 0);
                    } ops = new Minus();
                } case '*' -> {
                    if (ops != null && !ops.equals(new Mult())) {
                        throw new ParseException("Error", 0);
                    } ops = new Mult();
                }
            }
        }

        List<String> words = new ArrayList<>();

        sb = new StringBuilder();

        for (char buchstabe : ns.toCharArray()) {
            if (buchstabe == '+' || buchstabe == '-' || buchstabe == '*' || buchstabe == '=') {

                String ls = sb.toString(); words.add(ls); sb = new StringBuilder();
            }
            else sb.append(buchstabe);
        } words.add(sb.toString());

        return new Metic(ops, words);
    }
}