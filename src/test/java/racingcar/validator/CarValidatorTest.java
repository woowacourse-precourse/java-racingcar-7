package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarValidatorTest {

    @Test
    @DisplayName("자동차 수가 한 대 이상이 아닌 경우 IllegalArgumentException을 발생시킨다.")
    void validateCarNames_CarsLength_Exception() {
        // given
        String input1 = "";
        String input2 = " ";

        String expectedMessage = "자동차는 한 대 이상이어야 합니다.";

        // when, then
        assertThatThrownBy(() -> CarValidator.validateCarNames(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);

        assertThatThrownBy(() -> CarValidator.validateCarNames(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과인 경우 IllegalArgumentException을 발생시킨다.")
    void validateCarNames_CarsNameLength_Exception() {
        // given
        String input = "kiaaa,hyundai";

        String expectedMessage = "자동차 이름은 5자 이하여야 합니다.";

        // when, then
        assertThatThrownBy(() -> CarValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("자동차 이름이 중복될 경우 IllegalArgumentException을 발생시킨다.")
    void validateCarNames_duplicatedCarName_Exception() {
        // given
        String input = "kia,kia";

        String expectedMessage = "자동차 이름은 중복될 수 없습니다.";

        // when, then
        assertThatThrownBy(() -> CarValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);

    }

}
