package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @ParameterizedTest
    @DisplayName("사용자가 입력한 시도 횟수가 양의 정수가 아니면 예외를 던진다.")
    @ValueSource(strings = {"abc", "123abc", "-1", "42.5"})
    void throwExceptionWhenAttemptCountIsNotPositiveInteger(String inputValue) {
        // when & then
        assertThatThrownBy(() -> InputValidator.validateAttemptCount(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 양의 정수 형태로 입력하셔야 합니다.");
    }

}
