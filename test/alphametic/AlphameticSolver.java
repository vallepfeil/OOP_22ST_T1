//4

package alphametic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Klasse AlphameticSolver:
 * <p>
 * Generell:
 * * Teil 2:
 * * Zunächst Definition m als Class Metic
 * * Dann neue leere Liste: buchstabenbowl zur Filterung aller noch nicht
 * * vorhandenen Buchstaben
 * * Mit dem Erg Vgl. der Bedingung nicht mehr als 10 versch Buchstaben
 * * Bei mehr => Exception
 * Konstruktor:
 * * zahlen werden gespeichert, damit alle Belegungen ausprobiert werden können
 * * Buchstaben, die in Metic übernommen werden, werden auch schon gespeichert, damit alle Belegungen ausprobiert werden können
 * *
 * * @param metic
 * * @throws IllegalArgumentException
 * Methode solve:
 * * IDEE:
 * * solve() gibt die ERSTE Lösung wieder
 * * solveAll() gibt ALLE Lösungen wieder
 * * Hinweis: Welche Codeteile könnten ausgelagert vereinfacht werden?
 * * <p>
 * * Map<Character, Integer>
 * * Dazu Liste mit allen unterschiedlichen Buchstaben "List<Character> buchstaben"
 * * Probiere Belegungunen durch für buchstaben.get(0) 0, 1 ,2 ...
 * * Fange führende 0en ab => geschieht durch Metic.isSolution(...) Exception
 * * Gib buchstaben.get(1) die nächste freue Zahl
 * * Loop...
 * * <p>
 * * Unterschied der Anwendung des Brute-Force-Algorithmus:
 * * solve() führt solange aus bis eine Lösung gefunden wurde
 * * solveAll() führt danach mit Restmenge weiter aus
 * * s. OneNote, i:0/rek:0, exakt selbes Verfahren im solve()
 * <p>
 * * WDH:
 * * solve liefert die erste Möglichkeit (Lösung)
 * * solveAll() liefert alle Möglichkeiten (Alle Lösungen)
 * *
 * * @return
 * <p>
 * Liste findAllPermutations:
 * * 0) REKURSION-INVARIANTE:
 * * Nach jedem Rekursiven-aufrufe befinden sich in der List<Map<Character, Integer>> Alle Kombinationen aus C & I der durchlaufenen listC
 * * In der Methode, dürfen die übergegebenen Parameter nicht während der Rekursion verändert werden! Deshalb wird listC in myListC überführt!
 * <p>
 * * 1) ABBRUCHBEDINGUNG
 * * listC wird immer kleiner!
 * * listMap wird immer größer!
 * * Ist listC leer? → Gib listMap als Ergebnis aus!
 * <p>
 * Vor myListC:
 * * Lege Kopien der Collections an (damit diese während der Iteration verändert werden können!)
 * <p>
 * * Danach:
 * <p>
 * * 2a) REKURSIONSSCHRITT (Wie wird abbruch geregelt?)
 * * listC wird als "neue" myListC in jedem durchlauf 1 Element kürzer
 * * → DIES führt zum Abbruch der Rekursion
 * <p>
 * * Nach Entfernen eines Elements:
 * <p>
 * * 2b) REKURSIONSSCHRITT (Wie wird Ergebnis gewährleistet?)
 * * Füge für jede Map in der Liste listMap neue Kombinationen mit aktuellen c & allen möglichen (nicht bereits besuchten) Zahlen hinzu!
 * <p>
 * * Erstes Zeichen aus ListC entnehmen (listMap ist leer)
 * * dies ist der Sonderfall beim ersten Aufruf der Methode
 * <p>
 * * 1. Else im If:
 * * Für jede Map des vorherigen Rekursionsschritts...
 * * 1. For im else:
 * * für jede Zahl...
 * * 2. For im else:
 * * sofern diese noch nicht in der Map enthalten ist...
 * * 1. If im else:
 * * erstelle eine Kopie der alten Map...
 * *                           * und füge ihr den aktuellen Buchstaben mit der Zahl ein...
 * * Übergib diese Map mit neuem Buchstaben an die Liste für den nächsten Rekursionsschritt.
 * <p>
 * * @return          * 3) REKURSIVER AUFRUF
 * * Gib die nun größere Liste mit Maps,
 * * und die nun kleiner Liste mit Buchstaben
 * * in den nächsten Rekursiven-aufruf
 * <p>
 * In findFirstpermutation, nach myListC.remove:
 * * Im letzten Durchlauf der Erzeugung von Permutationen starte Prüfung auf valide Belegung
 * * If mit result check:
 * * Wenn Map für jedes C ein I gewählt hat prüfe ob schon Lösung vorhanden!
 */
public class AlphameticSolver {
    Metic m;
    List<Character> buchstabenbowl = new ArrayList<>();
    List<Integer> zahlen = new ArrayList<>();

    public AlphameticSolver(Metic metic) throws IllegalArgumentException {
        this.m = metic; for (String wort : m.getWords()) {
            for (char buchstabe : wort.toCharArray()) {
                if (!buchstabenbowl.contains(buchstabe)) buchstabenbowl.add(buchstabe);
            }
        } if (buchstabenbowl.size() > 10) {
            throw new IllegalArgumentException();
        } for (int i = 0; i < 10; i++) {
            zahlen.add(i);
        }
    }

    public Map<Character, Integer> solve() {
        return findFirstPermutation(new ArrayList<>(), buchstabenbowl);
    }

    public HashSet<Map<Character, Integer>> solveAll() {
        List<Map<Character, Integer>> allPermutations = findAllPermutations(new ArrayList<>(), buchstabenbowl);
        HashSet<Map<Character, Integer>> set = new HashSet<>(); for (Map<Character, Integer> map : allPermutations) {
            try {
                if (m.isSolution(map)) {
                    set.add(map);
                }
            }
            catch (IllegalArgumentException ignored) {
                System.out.println("Error");
            }
        } return set;
    }

    public List<Map<Character, Integer>> findAllPermutations(List<Map<Character, Integer>> listMap, List<Character> listC) {
        if (listC.isEmpty()) {
            return listMap;
        } List<Character> myListC = new ArrayList<>(listC); List<Map<Character, Integer>> myListMap = new ArrayList<>();
        char aktuellesC = myListC.remove(0); if (listMap.isEmpty()) {
            for (Integer i : zahlen) {
                Map<Character, Integer> newMap = new HashMap<>(); newMap.put(aktuellesC, i); myListMap.add(newMap);
            }
        }
        else {
            for (Map<Character, Integer> map : listMap) {
                for (Integer i : zahlen) {
                    if (!map.containsValue(i)) {
                        Map<Character, Integer> newMap = new HashMap<>(map); newMap.put(aktuellesC, i);
                        myListMap.add(newMap);
                    }
                }
            }
        } return findAllPermutations(myListMap, myListC);
    }

    public Map<Character, Integer> findFirstPermutation(List<Map<Character, Integer>> listMap, List<Character> listC) {
        if (listC.isEmpty()) {
            return null;
        } List<Character> myListC = new ArrayList<>(listC); List<Map<Character, Integer>> myListMap = new ArrayList<>();
        char aktuellesC = myListC.remove(0);

        boolean resultCheck = myListC.isEmpty();

        if (listMap.isEmpty()) {
            for (Integer i : zahlen) {
                Map<Character, Integer> newMap = new HashMap<>(); newMap.put(aktuellesC, i); myListMap.add(newMap);
            }
        }
        else {
            for (Map<Character, Integer> map : listMap) {
                for (Integer i : zahlen) {
                    if (!map.containsValue(i)) {
                        Map<Character, Integer> newMap = new HashMap<>(map); newMap.put(aktuellesC, i);
                        if (resultCheck) {
                            try {
                                if (m.isSolution(newMap)) {
                                    return newMap;
                                }
                            }
                            catch (IllegalArgumentException ignored) {
                                //System.out.println(""); //20220726_0950_Ä: catched ein Haufen Probleme, Test
                            }
                        }
                        else {
                            myListMap.add(newMap);
                        }
                    }
                }
            }
        } return findFirstPermutation(myListMap, myListC);
    }
}