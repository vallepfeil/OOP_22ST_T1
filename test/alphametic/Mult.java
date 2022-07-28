//1

package alphametic;

import java.util.List;

/**
 * * <p>
 * * Methode eval:
 * * <p>
 * * Allgemein:
 * * * Iteration der Operation?
 * * * 2 Wege:
 * * * Schleifen
 * * * oder Rekursion
 * * * Listen besonders gut für Rekursion, Arrays z. B. weniger
 * * * i. d. F. Schleifen schicker
 * * <p>
 * * Zu n:
 * * * n relevant für For-Schleife
 * * <p>
 * * Schleifenerklärung:
 * * * Size bei einer Liste mit 5 Elementen = 5
 * * * Also < und nicht <=  !
 * * * Fälle bei Bedingungen durchgehen, unterschiedliche Größen
 * * <p>
 * * * Wenn Liste leer => return 1;
 * * * Wenn Liste nicht leer => springe in for
 * * <p>
 * * Innerhalb 1. If:
 * * <p>
 * * * numbers.get, ähnlich wie bei numbers[i] vgl. Arrays
 * * Innerhalb 1. For:
 * * <p>
 * * * numbers.get, ähnlich wie bei numbers[i] vgl. Arrays
 * * <p>
 * * Methode equals:
 * * * Vgl. Nummer der Klasse (==), Primitiv
 * * * Guckt bei dem Objekt vorher, ob von der Klasse (Instanceof), Vom Typ Plus
 * *
 * * @param numbers Liste aus Nummern
 * * @return Boolean: Vgl. Nummer der Klasse (==), Primitiv, sowie vom selben Typ
 */
public class Mult extends Operator {
    @Override
    public String getSymbol() {
        return ("*");
    }

    @Override
    public int eval(List<Integer> numbers) {

        int n = 1;

        if (numbers.size() > 0) {

            for (Integer number : numbers) {

                n *= number;
            } return n;
        }
        else return 1;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true; return obj instanceof Mult;
    }
}