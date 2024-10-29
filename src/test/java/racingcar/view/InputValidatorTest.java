package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자 이하여야 한다")
    void validateCarNameLength() {
        // given
        String validCarName = "pobi";
        String invalidCarName = "javaji";

        // when & then - 유효한 이름
        assertThatNoException().isThrownBy(() -> InputValidator.validateCarNameLength(validCarName));

        // when & then - 유효하지 않은 이름
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateCarNameLength(invalidCarName));
    }

    @Test
    @DisplayName("시도 횟수는 숫자여야 한다")
    void validateAttemptCountIsNumber() {
        // given
        String validAttemptCount = "5";
        String invalidAttemptCount = "five";

        // when & then - 유효한 숫자
        assertThatNoException().isThrownBy(() -> InputValidator.validateAttemptCountIsNumber(validAttemptCount));

        // when & then - 유효하지 않은 숫자
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateAttemptCountIsNumber(invalidAttemptCount));
    }

    @Test
    @DisplayName("자동차 이름은 두 개 이상이어야 한다")
    void validateCarCounts() {
        // give
        List<Car> validCarList = List.of(new Car("pobi"), new Car("woni"));
        List<Car> invalidCarList = List.of(new Car("pobi"));

        // when & then - 유효한 자동차 개수
        assertThatNoException().isThrownBy(() -> InputValidator.validateCarCounts(validCarList));

        // when & then - 유효하지 않은 자동차 개수
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateCarCounts(invalidCarList));
    }

    @Test
    @DisplayName("자동차 이름은 중복될 수 없다")
    void validateDuplicateCarName() {
        // give
        List<Car> carList = new ArrayList<>();
        Car existingCar = new Car("pobi");
        carList.add(existingCar);
        Car nonDuplicateCar = new Car("woni");

        // when & then - 중복이 없는 경우
        assertThatNoException().isThrownBy(() -> InputValidator.validateDuplicateCarName(carList, nonDuplicateCar));

        // when & then - 중복이 있는 경우
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateDuplicateCarName(carList, existingCar));
    }

    @Test
    @DisplayName("입력이 비어있으면 안된다")
    void validateEmptyInput() {
        // given
        String validInput = "input";
        String emptyInput = "";

        // when & then - 비어있지 않은 입력
        assertThatNoException().isThrownBy(() -> InputValidator.validateEmptyInput(validInput));

        // when & then - 비어있는 입력
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidator.validateEmptyInput(emptyInput));
    }
}