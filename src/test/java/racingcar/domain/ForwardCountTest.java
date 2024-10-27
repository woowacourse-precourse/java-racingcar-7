package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ForwardCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", ";", "15a"})
    @DisplayName("전진을 시도하는 횟수에 숫자가 아닌 문자가 들어오면 예외가 발생한다.")
    void validateNumber(String candidate) {
        assertThatThrownBy(() -> ForwardCount.from(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 1~100 사이의 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings= {"-1", "-10", "101"})
    @DisplayName("전진을 시도하는 횟수에 1~100 사이가 아닌 숫자가 들어오면 예외가 발생한다.")
    void validateForwardCountOutOfRange(String candidate) {
        assertThatThrownBy(() -> ForwardCount.from(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 1~100 사이의 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings= {"1", "10", "55", "100"})
    @DisplayName("전진을 시도하는 횟수에 1~100 사이의 숫자가 입력되면 테스트는 통과한다.")
    void validateSingleDigitForwardCount(String candidate) {
        ForwardCount saveForwardCountCount = ForwardCount.from(candidate);
        int parseInt = Integer.parseInt(candidate);

        assertThat(saveForwardCountCount.getForwardCount())
                .isEqualTo(parseInt);
    }

}