package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exception.CarValidationError;
import racingcar.model.Car;
import racingcar.model.CarInformation;
import racingcar.model.CarMovementPolicy;
import racingcar.model.Cars;
import racingcar.model.DefaultCarMovementPolicy;
import racingcar.model.Name;

class CarsTest {

    final CarMovementPolicy movementPolicy = new DefaultCarMovementPolicy();

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

    @Test
    @DisplayName("모든 자동차의 이름과 위치를 반환해야 한다.")
    void getAllCarInformationTest() {
        // given
        Car pobi = new Car(Name.from("pobi"), movementPolicy);
        Car woni = new Car(Name.from("woni"), movementPolicy);
        Cars cars = new Cars(List.of(pobi, woni));
        woni.race(6);

        // when
        List<CarInformation> informations = cars.getAllCarInformation();

        // then
        assertAll(
                () -> assertEquals(2, informations.size()),
                () -> assertEquals("pobi", informations.getFirst().name()),
                () -> assertEquals("woni", informations.get(1).name()),
                () -> assertEquals(0, informations.getFirst().position()),
                () -> assertEquals(1, informations.get(1).position())
        );
    }
}