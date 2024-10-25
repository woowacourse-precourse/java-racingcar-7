package racingcar.racing.utils;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputParserTest {
    @Test
    void 레이싱카_파싱_성공() {
        //given
        String input = "hello,hi,ho,,";
        List<String> array = Arrays.asList("hello", "hi", "ho");
        //when
        //then
        Assertions.assertThat(InputParser.parseCarNames(input)).isEqualTo(array);
    }

}