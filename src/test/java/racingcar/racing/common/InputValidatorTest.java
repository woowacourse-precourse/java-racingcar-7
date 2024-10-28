package racingcar.racing.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 빈_문자열이_아니면_통과() {
        Assertions.assertSimpleTest(() -> {
            //given
            String one = ".";

            //when

            //then
            assertThatCode(() -> {
                InputValidator.validateInputNotEmpty(one);
            }).doesNotThrowAnyException();
        });
    }

    @Test
    void 빈_문자열_예외처리() {
        Assertions.assertSimpleTest(() -> {
            //given
            String empty = "";

            //when

            //then
            assertThatThrownBy(() -> {
                InputValidator.validateInputNotEmpty(empty);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 레이싱카_배열이_비었는지_유효성검사() {
        Assertions.assertSimpleTest(() -> {
            //given
            //when
            //then
        });
    }

    @Test
    void 레이싱카_이름_5자이하_유효성검사_통과() {
        Assertions.assertSimpleTest(() -> {
            //given
            List<String> carNames = Arrays.asList("Hello", "hiCar", "Hihic");

            //when

            //then
            assertThatCode(() -> {
                InputValidator.validateCarNameLength(carNames);
            }).doesNotThrowAnyException();
        });
    }

    @Test
    void 레이싱카_이름_5자이하_유효성검사_실패() {
        Assertions.assertSimpleTest(() -> {
            //given
            List<String> carNames = Arrays.asList("HelloCal", "hiCar", "Hihic");

            //when

            //then
            assertThatThrownBy(() -> {
                InputValidator.validateCarNameLength(carNames);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 시도횟수_유효성검사() {
        Assertions.assertSimpleTest(() -> {
            //given
            int zero = 0;
            int minus = -1;
            int one = 1;

            //when
            InputValidator.validateAttemptNumber(zero);
            //then
//            assertThat();
//            assertThat(InputValidator.validateAttemptNumber(minus));
//            assertThat(InputValidator.validateAttemptNumber(one));
        });
    }
}