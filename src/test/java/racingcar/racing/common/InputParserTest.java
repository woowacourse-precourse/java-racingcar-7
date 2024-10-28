package racingcar.racing.common;


import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {
    @Test
    void 레이싱카_기본_파싱_성공() {
        Assertions.assertSimpleTest(() -> {
            //given
            String input = "hello,hi,ho,,";

            //when
            List<String> parsingNames = InputParser.parseCarNames(input);

            //then
            assertThat(parsingNames).isEqualTo(Arrays.asList("hello", "hi", "ho"));
        });
    }

    @Test
    void 레이싱카_빈콤마_무시_파싱_성공() {
        Assertions.assertSimpleTest(() -> {
            //given
            String input = ",,,";

            //when
            List<String> parsingNames = InputParser.parseCarNames(input);

            //then
            assertThat(parsingNames).isEqualTo(Arrays.asList());
        });
    }

}