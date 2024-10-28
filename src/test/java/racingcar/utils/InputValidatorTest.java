package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.enums.ErrorMessage;

public class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"name1,name2,name3", "1,2,3", "a1,b2,c3", "Aaa,Bbb,Ccc"})
    void 자동차_이름_입력_검증_성공(String input) {
        InputValidator.validateCarNames(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"*&,name2,name3", " ,2,3", "::,b2,c3", "이름-,Bbb,Ccc", ",aa,bb,", "OVERLENGTH,name2,name3"})
    void 자동차_이름_입력_검증_실패(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAMES.getMessage());
    }

    @Test
    void 자동차_이름_입력_중복으로_검증_실패() {
        Assertions.assertThatThrownBy(() -> InputValidator.validateCarNames("aa,bb,aa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_NAMES.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1000", "30", "0"})
    void 시도_횟수_검증_성공(String input) {
        InputValidator.validateTrialCount(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "+11", "aa", "1001", "숫자"})
    void 시도_횟수_검증_실패(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateTrialCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_TRIAL_COUNT.getMessage());
    }

}
