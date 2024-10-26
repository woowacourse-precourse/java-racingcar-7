package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {
    Parser parser = new Parser();

    @Test
    void 구분자로_자동차_이름_파싱() {
        String testStr = "one,two,three,four,five";
        String testOperator = ",";
        List<String> expectedResult = new ArrayList<>(List.of("one", "two", "three", "four", "five"));

        List<String> result = parser.parseCarNamesByOperator(testStr, testOperator);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void parseRepeatCount() {
        String testStr = "15";
        long expected = 15;

        long result = parser.parseRepeatCount(testStr);
        assertThat(result).isEqualTo(expected);
    }

}