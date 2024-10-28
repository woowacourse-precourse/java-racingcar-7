package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exception.CarValidationError;
import racingcar.model.Car;
import racingcar.model.CarMovementPolicy;
import racingcar.model.Cars;
import racingcar.model.DefaultCarMovementPolicy;
import racingcar.model.Name;

class CarsTest {

    final CarMovementPolicy movementPolicy = DefaultCarMovementPolicy.getInstance();

    @Test
    @DisplayName("자동차가 1대 미만이면 예외가 발생해야 한다.")
    void lessThanMinimumCarsCountExceptionTest() {
        // given
        List<Car> cars = new ArrayList<>();

        // when, then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationError.LESS_THAN_MIN_CARS_COUNT_EXCEPTION.getMessage(1));
    }

    @Test
    @DisplayName("자동차가 10대를 초과하면 예외가 발생해야 한다.")
    void exceedsMaximumCarsCountExceptionTest() {
        // given
        List<String> names = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k");
        List<Car> cars = names.stream()
                .map(name -> new Car(Name.from(name), movementPolicy))
                .toList();

        // when, then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationError.EXCEEDS_MAX_CARS_COUNT_EXCEPTION.getMessage(10));
    }

    @Test
    @DisplayName("중복된 자동차가 존재하면 예외가 발생해야 한다.")
    void existsDuplicatedCarsExceptionTest() {
        // given
        Car car = new Car(Name.from("pobi"), movementPolicy);
        Car duplicatedCar = new Car(Name.from("pobi"), movementPolicy);
        List<Car> cars = List.of(car, duplicatedCar);

        // when, then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CarValidationError.DUPLICATED_CARS_EXISTS_EXCEPTION.getMessage());
    }
}