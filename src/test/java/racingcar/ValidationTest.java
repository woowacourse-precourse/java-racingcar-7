package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.message.ErrorMessage;
import view.validation.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    @DisplayName("경주할 자동차의 이름은 문자와 쉼표 이외의 값을 가질 수 없다")
    void 자동차이름_문자와쉼표이외의값_존재() {
        String cars = "pobi@juni";

        assertThatThrownBy(() -> InputValidator.validateCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SHAPE_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("쉼표(,)로 구분했을 때 자동차 이름이 존재해야 한다")
    void 자동차이름_존재하지_않을때() {
        String cars = "pobi, ,";

        assertThatThrownBy(() -> InputValidator.validateCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SHAPE_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("자동차의 이름은 1자 이상 5자 이하여야 한다")
    void 자동차이름길이() {
        String cars = "pobijjang,juni";

        assertThatThrownBy(() -> InputValidator.validateCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("자동차의 이름은 같을 수 없다")
    void 자동차이름동일여부() {
        String cars = "pobi,pobi";

        assertThatThrownBy(() -> InputValidator.validateCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EXIST_CAR_NAME_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("시도 횟수는 숫자로 이루어져야 한다")
    void 시도횟수_형식() {
        String count = "aa";

        assertThatThrownBy(() -> InputValidator.validateCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SHAPE_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("시도 횟수는 필수로 입력되어야 한다")
    void 시도횟수_입력여부() {
        String count = "";

        assertThatThrownBy(() -> InputValidator.validateCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_MESSAGE.getMessage());
    }
}
