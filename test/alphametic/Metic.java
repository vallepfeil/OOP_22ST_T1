//2

package alphametic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Klasse Metic:
 * Generell:
 * * operator operator
 * * liste words: letztes Wort immer Lsg-Wort
 * * Konstruktor, inkl. Getter-Meth; Input Liste, bei weniger als 2 Wörter => IllegArgExc
 * * Methoden: isSolution
 * * Zuordnung Zahlenwert zu Buchstabe als Map, DAZU
 * * IF Metik mit Buchstaben ohne Zahlenwert ODER 1. Buchstabe eines der Wörter MIT 0 als Zuordnung => IllegArgExc
 * * ELSE IF mit Rückgabe true/false, falls Zuordnung Metik löst(true)/keine Lsg (false)
 * * !!! Mehrere Buchstaben können denselben ZW zugeordnet werden, oder Zahlen >9
 * Attribute:
 * * Relevant für Getter- und Setter (Global/Lokal)
 * <p>
 * Konstruktor Metic:
 * * IllegalArgumentException() ist auch eine Klasse
 * * der Aufbau mit new [...] ist quasi die Erstellung eines Objekts dieser Klasse i. d. Form des Konstruktors
 * * zw. IF und Else im Konstruktor
 * * this im IF nicht nutzbar, weil es sonst noch null hat, siehe Zeile 18
 * * Konstruktor ist das Template, um ein Objekt zu erstellen
 * * d. h., am Anfang ist i. d. F. immer eine Kombi aus einer Liste + Operator zu übergeben
 * * Dann wirds ausgewertet, bei validen Daten weiterverarbeitet bzw. "lokal" eingespeichert
 */
public class Metic {
    Operator operator;
    List<String> words;

    public Metic(Operator operator, List<String> words) {
        if (words.size() < 2) {
            throw new IllegalArgumentException();
        }
        else {
            this.operator = operator; this.words = words;
        }
    }

    /**
     * Getter-Methode getOperator
     * * Getter-Methoden:
     * * Für Aufruf der Methoden z. B. via metic.getOperator(); (rekursive List)
     * * Da geschützt, aufgrund von Private, i. d. F. aber nicht geschützt worden
     * * Getter-Methoden machen die Aufrufe Public
     * * Attribute werden i. d. R. Privat gemacht
     *
     * @return operator
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * Getter-Methode getWords
     *
     * @return words
     */
    public List<String> getWords() {
        return words;
    }

    /**
     * Map genauer anschauen, ähnelt sehr den Tupeln!
     * Set genauso, nur 1 von einer Art! (wie bei einer Menge)
     * Zuerst Überprüfung auf legale Eingaben
     * Danach Vearbeitung!
     *
     * @param assignment Zuweisung eines Zahlenwerts zum Buchstaben in der Map
     * @return res == comp, Boolean, Vgl. von Resultat mit Vergleichswert
     * nach isSolution:
     * *
     * * Power/Super-for-Schleife: Für jeden String wort in Liste words
     * *
     * nach 1. For:
     * * Hol mir den Wert aus der Belegung für das Wort an der 0. Stelle, also den Value und vgl. mit 0
     * nach 1. If:
     * * Power/Super-for-Schleife: Für jeden Charakter buchstabe in CharArray() in dem String
     * * Gibt es zu jeden Buchstaben eine Belegung, d. h. einen Zahlenwert?
     * nach komplettem 1. For:
     * * Leere Liste für folgende For-Schleifen
     * Innerhalb neuer ArrayListe zahlen, bei Prüfung jedes einzelnen Buchstabens:
     * * Füge für jeden Buchstaben den korrespondierenden Zahlenwert ein
     * * Dezimalzahlen stellenweise von links nach rechts Zahlen zusammenfügen
     * * 1. eingelesene Zahl ist die Größte
     * * Zahl 915
     * * 9 * 10^2
     * * 1 * 10^1
     * * 5 * 10^0
     * zahlen.add(zahl):
     * <p>
     * * Hier stehen alle Zahlen drin, also in zahlen
     * Korrektheit der Berechnung - nach res/comp:
     * <p>
     * * Die Berechnung wird anhand dieses Calls gemacht, mit sämtlichen Zahlen aus zahlen
     * * Comp vgl. Wert aus der Rechnung mit dem Wert des Lösungswortes, d. h. der Vgl. aus res und comp überprüft
     * * die Rechnung auf Korrektheit
     */
    boolean isSolution(Map<Character, Integer> assignment) {
        for (String wort : words) {
            if (assignment.get(wort.charAt(0)) > 0) {
                for (char buchstabe : wort.toCharArray()) {
                    if (!assignment.containsKey(buchstabe)) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            else {
                throw new IllegalArgumentException();
            }
        }

        List<Integer> zahlen = new ArrayList<>(); for (String wort : words) {
            int zahl = 0; for (char buchstabe : wort.toCharArray()) {
                int a = assignment.get(buchstabe); zahl *= 10; zahl += a;
            } zahlen.add(zahl);
        }

        int res; int comp; comp = zahlen.remove(zahlen.size() - 1); res = operator.eval(zahlen); return res == comp;
    }
}