package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidateCountTest {

    @DisplayName("빈 문자열이나 자연수가 아닌 값들이 들어오면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "-1", "0", "pobi"})
    void 시도횟수_예외_테스트(String userCount) {
        assertThatThrownBy(() -> ValidateCount.validateInputCount(userCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}