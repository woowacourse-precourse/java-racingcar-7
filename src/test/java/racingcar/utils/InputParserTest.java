package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    void 자동차_이름_분리_테스트() {
        String input = "hhj,hixzg,mongl";
        List<String> names = InputParser.getNames(input);

        assertThat(names).containsExactly("hhj", "hixzg", "mongl");
    }
}
