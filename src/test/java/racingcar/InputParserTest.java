package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputParserTest {
    @Test
    void testParseCarNamesWhenValidInput() {
        assertEquals(List.of("a"), InputParser.parseCarNames("a"));
        assertEquals(List.of("a", "b"), InputParser.parseCarNames("a,b"));
        assertEquals(List.of("a", "b", "c", "d", "e", "f", "g"), InputParser.parseCarNames("a,b,c,d,e,f,g"));
        assertEquals(List.of("a", "b", "abcde", "d", "e", "f", "g"), InputParser.parseCarNames("a,b,abcde,d,e,f,g"));
    }

    @Test
    void testParseCarNamesWhenInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames(""));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames(","));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames(",,,,,,"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames("a,b,c,,d,e,f"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames("a,b,c,d,e,f,"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames(",a,b,c,d,e,f"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames("a,b,,c,d,,e,f"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames("a,b,,c,d,,e,f"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames("a,b,c,d,e ,f"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames(" a,b,c,d,e,f"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames("a,b,c,d,e,f "));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames(" "));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames("abcdef"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames("a,b,c,d,abcdef,e,f "));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseCarNames("a,abcde,c,abcde"));
    }

    @Test
    void testParseMaxRoundWhenValidInput() {
        assertEquals(1, InputParser.parseMaxRound("1"));
        assertEquals(2, InputParser.parseMaxRound("2"));
        assertEquals(3, InputParser.parseMaxRound("3"));
        assertEquals(4, InputParser.parseMaxRound("4"));
        assertEquals(5, InputParser.parseMaxRound("5"));
        assertEquals(6, InputParser.parseMaxRound("6"));
        assertEquals(7, InputParser.parseMaxRound("7"));
        assertEquals(8, InputParser.parseMaxRound("8"));
        assertEquals(9, InputParser.parseMaxRound("9"));
        assertEquals(10, InputParser.parseMaxRound("10"));
        assertEquals(100, InputParser.parseMaxRound("100"));
    }

    @Test
    void testParseMaxRoundWhenInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseMaxRound(""));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseMaxRound(" "));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseMaxRound("a"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseMaxRound("1.1"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseMaxRound("0"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseMaxRound("-1"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseMaxRound("-10"));
        assertThrows(IllegalArgumentException.class, () -> InputParser.parseMaxRound(" 1"));
    }
}
