package racingcar.racing.common;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 빈_문자열_검사() {
        //given
        //when
        //then
    }

    @Test
    void 레이싱카_배열이_비었는지_유효성검사(){
        //given
        //when
        //then
    }

    @Test
    void 레이싱카_이름_길이_유효성검사() {
        // given
        List<String> carNames1 = Arrays.asList("HelloCal", "hiCar", "Hihic");
        List<String> carNames2 = Arrays.asList("Hello", "hiCar", "Hihic");
        // when
        // then
//        Assertions.assertThat(InputValidator.validateCarNameLength(carNames1));
//        Assertions.assertThat(InputValidator.validateCarNameLength(carNames2));
    }

    @Test
    void 시도횟수_유효성검사() {
        // given
        int zero = 0;
        int minus = -1;
        int one = 1;
        // when
        // then
//        Assertions.assertThat(InputValidator.validateAttemptNumber(zero);)();
//        Assertions.assertThat(InputValidator.validateAttemptNumber(minus);).isFalse();
//        Assertions.assertThat(InputValidator.validateAttemptNumber(one);).isTrue();
    }
}