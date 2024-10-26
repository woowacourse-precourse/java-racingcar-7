package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {
    private final Parser parser = new Parser();

    @Test
    void 쉼표를_기준으로_파싱() {
        String input = "자동차1, 자동차2, 자동차3";
        List<String> expected = List.of("자동차1", "자동차2", "자동차3");
        assertEquals(expected, parser.parse(input));
    }
}