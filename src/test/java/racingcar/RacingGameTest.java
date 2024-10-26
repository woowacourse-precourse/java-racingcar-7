package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("경주 횟수 검증 테스트")
public class RacingGameTest {
    @Test
    @DisplayName("시도 횟수가 양의 정수가 아니면 예외가 발생한다")
    void validateTryCount() {
        assertThatThrownBy(() -> new RacingGame(Cars.createCarsFrom("yoon"), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양의 정수여야 합니다.");
    }
}
