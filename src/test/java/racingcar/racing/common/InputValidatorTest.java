package racingcar.racing.common;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 비지_않은_문자열_검사_성공() {
        Assertions.assertSimpleTest(() -> {
            //given
            String full = "abcd";

            //when

            //then
            assertThatCode(() -> {
                InputValidator.validateInputNotEmpty(full);
            }).doesNotThrowAnyException();
        });
    }

    @Test
    void 비지_않은_문자열_검사_실패() {
        Assertions.assertSimpleTest(() -> {
            //given
            String empty = "";
            String nullString = null;

            //when

            //then
            assertThatThrownBy(() -> {
                InputValidator.validateInputNotEmpty(empty);
            }).isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> {
                InputValidator.validateInputNotEmpty(nullString);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 레이싱카_배열이_비었는지_유효성검사_성공() {
        Assertions.assertSimpleTest(() -> {
            //given
            List<String> carNames = Arrays.asList("car1", "car2", "car3");

            //when

            //then
            assertThatCode(() -> {
                InputValidator.validateCarArrayNotEmpty(carNames);
            }).doesNotThrowAnyException();
        });
    }

    @Test
    void 레이싱카_배열이_비었는지_유효성검사_실패() {
        Assertions.assertSimpleTest(() -> {
            //given
            List<String> carNames1 = new ArrayList<>();

            //when

            //then
            assertThatThrownBy(() -> {
                InputValidator.validateCarArrayNotEmpty(carNames1);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 레이싱카_이름_5자이하_유효성검사_성공() {
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
    void 시도횟수_유효성검사_성공() {
        Assertions.assertSimpleTest(() -> {
            //given
            int one = 1;

            //when

            //then
            assertThatCode(() -> {
                InputValidator.validateAttemptNumber(one);
            }).doesNotThrowAnyException();
        });
    }

    @Test
    void 시도횟수_유효성검사_실패() {
        Assertions.assertSimpleTest(() -> {
            //given
            int zero = 0;
            int minus = -1;

            //when

            //then
            assertThatThrownBy(() -> {
                InputValidator.validateAttemptNumber(zero);
            }).isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> {
                InputValidator.validateAttemptNumber(minus);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }
}