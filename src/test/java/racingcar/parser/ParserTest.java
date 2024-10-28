package racingcar.parser;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.util.Parser;

public class ParserTest {
    @Test
    @DisplayName("자동차 이름 파싱 테스트")
    void parseCarNamesTest() {
        String input = "car1, car2, car3";
        List<String> result = Parser.parseCarNames(input);

        assertArrayEquals(new String[]{"car1", "car2", "car3"}, result.toArray());
    }
}
