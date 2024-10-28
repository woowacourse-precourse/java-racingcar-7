package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceValidatorTest {

    @Test
    @DisplayName("차 리스트가 null일 경우 예외를 발생시킨다.")
    void validate_nullCarList_throwsException() {
        // given
        List<Car> nullCarList = null;

        // when & then
        assertThatThrownBy(() -> RaceValidator.validate(nullCarList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Car 리스트가 null일 수 없습니다.");
    }

    @Test
    @DisplayName("차 리스트에 null이 포함될 경우 예외를 발생시킨다.")
    void validate_nullCarInList_throwsException() {
        // given
        List<Car> carsWithNull = Arrays.asList(new Car("Car1", () -> true), null);

        // when & then
        assertThatThrownBy(() -> RaceValidator.validate(carsWithNull))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Car 리스트에 null 값을 포함할 수 없습니다.");
    }

    @Test
    @DisplayName("차 이름이 중복될 경우 예외를 발생시킨다.")
    void validate_duplicateCarNames_throwsException() {
        // given
        List<Car> carsWithDuplicateNames = Arrays.asList(
                new Car("Car1", () -> true),
                new Car("Car1", () -> true),
                new Car("Car2", () -> true)
        );

        // when & then
        assertThatThrownBy(() -> RaceValidator.validate(carsWithDuplicateNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다: Car1");
    }

    @Test
    @DisplayName("모든 차 이름이 고유할 경우 예외가 발생하지 않는다.")
    void validate_uniqueCarNames_noException() {
        // given
        List<Car> uniqueCars = Arrays.asList(
                new Car("Car1", () -> true),
                new Car("Car2", () -> true),
                new Car("Car3", () -> true)
        );

        // when & then
        RaceValidator.validate(uniqueCars);
    }
}