package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.enums.ExceptionMessages;
import racingcar.exception.CarNameException;

public class CarTest {

    @Test
    @DisplayName("정상적인 이름이 입력 테스트")
    void createCar_withValidName() {
        // given
        String validName = "pobi";

        // when
        Car car = new Car(validName);

        // then
        assertThat(car.getName()).isEqualTo(validName);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("이름이 비어 있을 경우 예외 테스트")
    void createCar_withEmptyName() {
        // given
        String emptyName = "";

        // when & then
        assertThatThrownBy(() -> new Car(emptyName)).isInstanceOf(CarNameException.class)
                .hasMessage(ExceptionMessages.EMPTY_INPUT.getMessage());
    }

    @Test
    @DisplayName("이름이 공백일 경우 예외 테스트")
    void createCar_withBlankName() {
        // given
        String blankName = "   ";

        // when & then
        assertThatThrownBy(() -> new Car(blankName)).isInstanceOf(CarNameException.class)
                .hasMessage(ExceptionMessages.EMPTY_INPUT.getMessage());
    }

    @Test
    @DisplayName("이름이 5자를 초과할 경우 예외 테스트")
    void createCar_withNameExceedingMaxLength_shouldThrowException() {
        // given
        String longName = "abcdef";

        // when & then
        assertThatThrownBy(() -> new Car(longName)).isInstanceOf(CarNameException.class)
                .hasMessage(ExceptionMessages.INVALID_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("이름에 쉼표가 포함된 경우 예외 테스트")
    void createCar_withCommaInName_shouldThrowException() {
        // given
        String invalidName = "po,bi";

        // when & then
        assertThatThrownBy(() -> new Car(invalidName)).isInstanceOf(CarNameException.class)
                .hasMessage(ExceptionMessages.INVALID_COMMA_INPUT.getMessage());
    }

    @Test
    @DisplayName("자동차가 이동할 때 위치 테스트")
    void moveForward_shouldIncreasePosition() {
        // given
        Car car = new Car("pobi");

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
