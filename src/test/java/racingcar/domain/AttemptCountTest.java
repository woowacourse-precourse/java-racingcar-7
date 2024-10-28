package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptCountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("유효한 시도 횟수인 경우 객체 생성에 성공한다.")
    void 유효한_시도_횟수(int numberOfAttempts) {
        AttemptCount attemptCount = new AttemptCount(numberOfAttempts);
        assertThat(attemptCount.numberOfAttempts()).isEqualTo(numberOfAttempts);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    @DisplayName("시도 횟수가 1 미만인 경우 예외를 발생시킨다.")
    void 시도_횟수_유효성_검사_예외(int numberOfAttempts) {
        assertThatThrownBy(() -> new AttemptCount(numberOfAttempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }
}