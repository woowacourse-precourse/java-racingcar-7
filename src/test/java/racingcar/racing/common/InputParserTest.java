package racingcar.racing.common;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {
    @Test
    void 레이싱카_기본_파싱_성공() {
        Assertions.assertSimpleTest(() -> {
            //given
            String input = "hello,hi,ho";

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

    @Test
    void 시도횟수_숫자_변환_성공() {
        Assertions.assertSimpleTest(() -> {
            //given
            String before = "12";

            //when
            int after = InputParser.parseAttemptNumber(before);

            //then
            assertThat(after).isEqualTo(12);
        });
    }

    @Test
    void 시도횟수_숫자_변환_실패() {
        Assertions.assertSimpleTest(() -> {
            //given
            String charFail = "a";

            //when

            //then
            assertThatThrownBy(() -> {
                InputParser.parseAttemptNumber(charFail);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

}