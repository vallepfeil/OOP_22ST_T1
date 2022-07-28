//1

package alphametic;

import java.util.List;

/**
 * * Abstrakte Klasse: Klasse ohne Objekte, zur Vererbung von Eigenschaften/Attributen und Methoden
 * * Kein Konstruktor
 * <p>
 * Methode hashCode():
 * * * Überschreibt das was er eigentlich erben würde, i. d. F. von der Abstract Class Operator
 * * * Generell: Objekte erben von der Klasse Object eigene Methoden
 * *
 * * @return
 */
public abstract class Operator {

    public abstract String getSymbol();

    public abstract int eval(List<Integer> numbers);

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);
}