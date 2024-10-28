package racingcar.ValidatorTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Validator;

public class EmptyTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("빈 자동차 이름")
    void ValidateEmptyCarName() {
        assertThatCode(() -> validator.validateInput("\n", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력하셔야 합니다. 이름은 쉼표(,) 기준으로 구분하여 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("null 값의 자동차 이름")
    void ValidateNullCarName() {
        assertThatCode(() -> validator.validateInput(null, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력하셔야 합니다. 이름은 쉼표(,) 기준으로 구분하여 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("빈 시도 횟수")
    void ValidateEmptyRounds() {
        assertThatCode(() -> validator.validateInput("pobi,woni", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수를 입력해주세요. 입력할 수 있는 값은 1이상 1000이하 입니다.");
    }

}
