package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.util.InputValidator;

class InputValidatorTest {
    @Test
    void CarNameIsLongerThanFiveCharactersTest() {
        assertThatThrownBy(() -> InputValidator.validateCarName("LongCarName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능하다.");
    }

    @Test
    void AttemptCountTest() {
        assertThatThrownBy(() -> InputValidator.validateAttemptCount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }
}