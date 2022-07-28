package alphametic;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AlphameticTest {
    public static final String METIC1 = "send+more=money";
    public static final Map<Character, Integer> SOLUTION1 = Map.of('m', 1, 'n', 6, 'o', 0, 'r', 8, 's', 9, 'd', 7, 'e', 5, 'y', 2);
    public static final Map<Character, Integer> SOLUTION1A = Map.of('m', 3, 'n', 6, 'o', 0, 'r', 8, 's', 9, 'd', 7, 'e', 5, 'y', 2);
    public static final Map<Character, Integer> SOLUTION1B = Map.of('m', 0, 'n', 6, 'o', 1, 'r', 8, 's', 9, 'd', 7, 'e', 5, 'y', 2);

    public static final String METIC2 = "VATER+MUTTER=ELTERN";
    public static final Set<Map<Character, Integer>> SOLUTION2 = Set.of(Map.of('l', 3, 'm', 1, 'n', 0, 'r', 5, 'a', 9, 't', 6, 'u', 4, 'v', 8, 'e', 2), Map.of('l', 3, 'm', 1, 'n', 0, 'r', 5, 'a', 9, 't', 6, 'u', 8, 'v', 4, 'e', 2), Map.of('l', 1, 'm', 6, 'n', 8, 'r', 4, 'a', 0, 't', 3, 'u', 2, 'v', 9, 'e', 7), Map.of('l', 1, 'm', 3, 'n', 8, 'r', 9, 'a', 0, 't', 2, 'u', 5, 'v', 6, 'e', 4), Map.of('l', 3, 'm', 1, 'n', 8, 'r', 4, 'a', 9, 't', 6, 'u', 5, 'v', 7, 'e', 2), Map.of('l', 1, 'm', 3, 'n', 8, 'r', 9, 'a', 0, 't', 2, 'u', 6, 'v', 5, 'e', 4), Map.of('l', 3, 'm', 1, 'n', 8, 'r', 4, 'a', 9, 't', 6, 'u', 7, 'v', 5, 'e', 2), Map.of('l', 1, 'm', 6, 'n', 8, 'r', 4, 'a', 0, 't', 3, 'u', 9, 'v', 2, 'e', 7));
    public static final String METIC3 = "Forty+Ten+Ten=sixty";
    public static final Map<Character, Integer> SOLUTION3 = Map.of('t', 8, 'x', 4, 'e', 5, 'f', 2, 'y', 6, 'i', 1, 'n', 0, 'o', 9, 'r', 7, 's', 3);

    public static final String METIC4 = "ADAM+AND+EVE=MOVED";
    public static final Map<Character, Integer> SOLUTION4 = Map.of('m', 1, 'n', 7, 'a', 8, 'o', 0, 'd', 5, 'e', 9, 'v', 3);

    public static final String METIC5 = "HEAR+THOSE+THREE=CHEERS";
    public static final Map<Character, Integer> SOLUTION5 = Map.of('o', 3, 'a', 8, 'r', 5, 's', 9, 'c', 1, 't', 6, 'e', 7, 'h', 2);

    public static final String METIC6 = "five+five+nine+eleven=thirty";
    public static final Map<Character, Integer> SOLUTION6 = Map.of('t', 8, 'v', 2, 'e', 7, 'f', 4, 'y', 6, 'h', 1, 'i', 0, 'l', 9, 'n', 5, 'r', 3);

    public static final String METIC7 = "THREE+THREE+THREE+ELEVEN=TWENTY";
    public static final Map<Character, Integer> SOLUTION7 = Map.of('h', 3, 'l', 9, 'n', 6, 'r', 5, 't', 7, 'v', 0, 'e', 4, 'w', 1, 'y', 8);

    public static final String METIC8 = "CROSS+ROADS=DANGER";
    public static final Map<Character, Integer> SOLUTION8 = Map.of('n', 8, 'o', 2, 'r', 6, 'a', 5, 's', 3, 'c', 9, 'd', 1, 'e', 4, 'g', 7);

    public static final String METIC9 = "COLORS-ORANGE=GREEN";
    public static final Map<Character, Integer> SOLUTION9 = Map.of('l', 9, 'n', 6, 'o', 1, 'r', 3, 'a', 5, 's', 0, 'c', 2, 'e', 4, 'g', 8);

    public static final String METIC10 = "iowa*ohio=florida";
    public static final Set<Map<Character, Integer>> SOLUTION10 = Set.of(Map.of('h', 6, 'i', 3, 'l', 2, 'o', 1, 'r', 4, 'a', 7, 'd', 0, 'w', 9, 'f', 5), Map.of('h', 2, 'i', 6, 'l', 8, 'o', 1, 'r', 0, 'a', 4, 'd', 3, 'w', 9, 'f', 7));
    public static final String METIC11 = "two*six=twelve";
    public static final Set<Map<Character, Integer>> SOLUTION11 = Set.of(Map.of('i', 8, 'l', 1, 'o', 5, 's', 9, 't', 3, 'v', 7, 'e', 0, 'w', 4, 'x', 6), Map.of('i', 7, 'l', 3, 'o', 5, 's', 9, 't', 1, 'v', 8, 'e', 0, 'w', 6, 'x', 2), Map.of('i', 6, 'l', 3, 'o', 8, 's', 9, 't', 2, 'v', 7, 'e', 0, 'w', 1, 'x', 5));
    public static final String METIC12 = "v*vi=xxx";
    public static final Map<Character, Integer> SOLUTION12 = Map.of('x', 1, 'i', 7, 'v', 3);

    public static final List<String> METICS = List.of(METIC1, METIC2, METIC3, METIC4, METIC5, METIC6, METIC7, METIC8, METIC9, METIC10, METIC11, METIC12);

    public static final String LS = System.lineSeparator();
    public static final String METIC_EX = "SO + MANY + MORE + MEN + SEEM + TO + SAY + THAT +" + LS + "THEY + MAY + SOON + TRY + TO + STAY + AT + HOME +" + LS + "SO + AS + TO + SEE + OR + HEAR + THE + SAME + ONE +" + LS + "MAN + TRY + TO + MEET + THE + TEAM + ON + THE +" + LS + "MOON + AS + HE + HAS + AT + THE + OTHER + TEN" + LS + "= TESTS";

    @Test
    public void testAddition() {
        AlphameticSolver as = new AlphameticSolver(MeticParser.run(METIC1)); assertEquals(SOLUTION1, as.solve());

        as = new AlphameticSolver(MeticParser.run(METIC2)); if (!SOLUTION2.contains(as.solve())) fail();

        as = new AlphameticSolver(MeticParser.run(METIC3)); assertEquals(SOLUTION3, as.solve());

        as = new AlphameticSolver(MeticParser.run(METIC4)); assertEquals(SOLUTION4, as.solve());
    }

    @Test
    public void testSubtraction() {
        AlphameticSolver as = new AlphameticSolver(MeticParser.run(METIC9)); assertEquals(SOLUTION9, as.solve());
    }

    @Test
    public void testMultiplication() {
        AlphameticSolver as = new AlphameticSolver(MeticParser.run(METIC12)); assertEquals(SOLUTION12, as.solve());
    }

    @Test
    public void testIsSolution1() {
        final Metic m = new Metic(new Plus(), List.of("send", "more", "money")); assertTrue(m.isSolution(SOLUTION1));
        assertFalse(m.isSolution(SOLUTION1A));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsSolution2() {
        final Metic m = new Metic(new Plus(), List.of("send", "more", "money")); m.isSolution(SOLUTION3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsSolution3() {
        final Metic m = new Metic(new Plus(), List.of("send", "more", "money")); m.isSolution(SOLUTION1B);
    }

    @Test
    public void paserTest1() {
        for (String metic : METICS)
            MeticParser.run(metic);
    }

    @Test
    public void paserTest2() {
        Metic m = MeticParser.run(METIC1); assertEquals(new Plus(), m.getOperator());
        assertEquals(List.of("send", "more", "money"), m.getWords());

        m = MeticParser.run(METIC9); assertEquals(new Minus(), m.getOperator());
        assertEquals(List.of("colors", "orange", "green"), m.getWords());

        m = MeticParser.run(METIC12); assertEquals(new Mult(), m.getOperator());
        assertEquals(List.of("v", "vi", "xxx"), m.getWords());
    }

    @Test
    public void parserTest3() {
        Metic m = MeticParser.run(METIC_EX); assertEquals(new Plus(), m.getOperator());
        assertEquals(42, m.getWords().size());
    }

    @Test(expected = ParseException.class)
    public void parserTest4() throws ParseException {
        MeticParser.run("send+me-more=money");
    }

    @Test(expected = ParseException.class)
    public void parserTest5() throws ParseException {
        MeticParser.run("send+me+more+money");
    }
}
