package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    private final InputParser inputParser = new InputParser();

    @Test
    void 단일_이름_파싱() {
        String initialInput = "pobi";

        List<String> parsed = inputParser.parseName(initialInput);

        assertEquals(1, parsed.size());
        assertEquals("pobi", parsed.get(0));
    }

    @Test
    void 복수_이름_파싱() {
        String initialInput = "pobi,woni";

        List<String> parsed = inputParser.parseName(initialInput);

        assertEquals(2, parsed.size());
        assertEquals("pobi", parsed.get(0));
        assertEquals("woni", parsed.get(1));
    }
}