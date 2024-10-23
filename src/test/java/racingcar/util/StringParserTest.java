package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringParserTest {

    @Test
    void 차_이름_파싱하기_테스트() {
        String input = "pobi,woni,jun";
        List<String> result = Arrays.asList("pobi", "woni", "jun");

        assertEquals(result, StringParser.parseCarName(input));
    }
}
