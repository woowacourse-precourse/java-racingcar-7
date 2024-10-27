package racingcar.model.Util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    @Test
    void 기본_구분자_사용한_문자열_파싱_테스트() {
        String input = "car1,car2,car3";
        List<String> expected = Arrays.asList("car1", "car2", "car3");

        List<String> result = parser.inputParser(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 단일_요소_테스트() {
        String input = "car1";
        List<String> expected = Arrays.asList("car1");

        List<String> result = parser.inputParser(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 구분자가_연속으로_나오는_경우_테스트() {
        String input = "car1,,car2";
        List<String> expected = Arrays.asList("car1", "", "car2");

        List<String> result = parser.inputParser(input);

        assertThat(result).isEqualTo(expected);
    }

}
