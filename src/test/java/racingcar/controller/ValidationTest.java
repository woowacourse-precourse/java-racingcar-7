package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ValidationTest {

    Validation validation = new Validation();

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void carNameLength_ShouldThrowException_WhenNameIsTooLong() {
        assertThatThrownBy(() -> validation.carNameLength("aaaaaaaaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능하다.");
    }

    
}
