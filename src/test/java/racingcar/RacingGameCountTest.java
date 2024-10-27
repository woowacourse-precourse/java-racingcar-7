package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("경주 횟수 검증 테스트")
public class RacingGameCountTest {
    @Test
    @DisplayName("시도 횟수가 양의 정수가 아니면 예외가 발생한다")
    void validateTryCount() {
        assertThatThrownBy(() -> new RacingGameCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양의 정수여야 합니다.");
    }

    @Test
    @DisplayName("올바른 시도 횟수로 게임을 생성할 수 있다")
    void createGameWithValidTryCount() {
        assertThatCode(() -> new RacingGameCount("5"))
                .doesNotThrowAnyException();
    }
}
