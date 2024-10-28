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
    }
}
