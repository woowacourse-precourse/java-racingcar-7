package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    void 자동차_이름_파싱_테스트() {
        String input = "hhj,hixzg,mongl";
        List<String> names = InputParser.getNames(input);

        assertThat(names).containsExactly("hhj", "hixzg", "mongl");
    }

    @Test
    void 게임_횟수_파싱_테스트() {
        String input = "12";

        assertThat(InputParser.getRepeatCount(input)).isEqualTo(12);
    }
}
