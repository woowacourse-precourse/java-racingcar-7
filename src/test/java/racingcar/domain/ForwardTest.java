package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ForwardTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", ";", "15a"})
    @DisplayName("전진을 시도하는 횟수에 숫자가 아닌 문자가 들어오면 예외가 발생한다.")
    void validateNumber(String candidate) {
        assertThatThrownBy(() -> Forward.from(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("전진을 시도할 횟수는 0~9 사이의 숫자만 입력 가능합나다.");
    }

    @ParameterizedTest
    @ValueSource(strings= {"-1", "-10", "10"})
    @DisplayName("전진을 시도하는 횟수에 0~9가 아닌 숫자가 들어오면 예외가 발생한다.")
    void validateNonNegativeNumber(String candidate) {
        assertThatThrownBy(() -> Forward.from(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("전진을 시도할 횟수는 0~9 사이의 숫자만 입력 가능합나다.");
    }

}