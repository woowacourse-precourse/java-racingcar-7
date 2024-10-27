package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingRacingGameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"대한민국", "3.14", "-123", "0123"})
    void 시도횟수_유효성_검증_예외발생_테스트(String numAttempts) {
        assertThatThrownBy(() -> {
            RacingGameValidator.validate(numAttempts);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("부적절한 형식의 시도 횟수를 입력했습니다. (시도 횟수는 양수)");
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "100", "999999999"})
    void 시도횟수_유효성_검증_정상_테스트(String numAttempts) {
        assertThatCode(() -> {
            RacingGameValidator.validate(numAttempts);
        }).doesNotThrowAnyException();
    }

    @Test
    void 시도횟수_최대값_초과시_예외발생_테스트() {
        assertThatThrownBy(() -> {
            String numAttempts = Long.valueOf((long)Integer.MAX_VALUE + 1).toString();
            RacingGameValidator.validate(numAttempts);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("입력된 시도 횟수가 허용된 최대 값을 초과했습니다.");
    }
}