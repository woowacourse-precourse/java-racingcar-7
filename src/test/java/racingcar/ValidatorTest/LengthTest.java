package racingcar.ValidatorTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Validator;

public class LengthTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("5자 이상의 자동차 이름 입력")
    void ValidateOverNameLength() {
        assertThatCode(() -> validator.validateInput("kartrider,pobi", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("5자 이하의 자동차 이름 입력")
    void ValidateRightLength() {
        assertThatCode(() -> validator.validateInput("rider,p", 2))
                .doesNotThrowAnyException();
    }

}
