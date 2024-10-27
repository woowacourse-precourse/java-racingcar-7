package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.service.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameValidatorTest{

    @Test
    @DisplayName("자동차 이름이 5자 이하면 검증 통과")
    void validateValidName() {
        // given
        String validName = "pobi";

        // when & then
        assertThatCode(() -> CarNameValidator.validate(validName))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void validateInvalidName() {
        // given
        String invalidName = "pobiii";

        // when & then
        assertThatThrownBy(() -> CarNameValidator.validate(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
