package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringParserTest {

    @Test
    void 차_이름_파싱하기_테스트() {
        // given
        String input = "pobi,woni,jun";
        List<String> expectedCarNames = Arrays.asList("pobi", "woni", "jun");

        // when, then
        assertEquals(expectedCarNames, StringParser.parseCarName(input));
    }
}
