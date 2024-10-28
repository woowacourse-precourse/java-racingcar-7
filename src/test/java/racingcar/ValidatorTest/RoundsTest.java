package racingcar.ValidatorTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Validator;

public class RoundsTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("시도 횟수로 0 입력")
    void Validate0Rounds() {
        assertThatCode(() -> validator.validateInput("pobi,woni", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1이상이어야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수로 1000 초과값 입력")
    void ValidateOverMaxRounds() {
        assertThatCode(() -> validator.validateInput("pobi,woni", 1004))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1000이하이어야 합니다.");
    }

    @Test
    @DisplayName("올바른 시도 횟수 입력")
    void ValidateRightRounds() {
        assertThatCode(() -> validator.validateInput("pobi,woni", 500))
                .doesNotThrowAnyException();
    }

}
