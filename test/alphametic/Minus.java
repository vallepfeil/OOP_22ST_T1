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
 * * * i. d. F. das n = 0 geändert auf numbers.get(0), also 1. Stelle der Numbers, da der Testfall für Subtraktion
 * * * das hergibt, im Anschluss wird die 2. Stelle der Numbers abgezogen
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
public class Minus extends Operator {
    @Override
    public String getSymbol() {
        return ("-");
    }

    @Override
    public int eval(List<Integer> numbers) {
        int n = numbers.get(0); for (int i = 1; i < numbers.size(); i++) {
            n -= numbers.get(i);
        } return n;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true; return obj instanceof Minus;
    }
}