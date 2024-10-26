package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarServiceTest {

    private final CarService carService = new CarService();

    @Test
    @DisplayName("자동차 리스트 생성")
    void makeCars() {
        //given
        final List<String> carNames = new ArrayList<>();
        carNames.add("a");
        carNames.add("b");
        carNames.add("c");

        //when
        final List<Car> cars = carService.createCars(carNames);

        //then
        Car firstCar = cars.getFirst();
        Assertions.assertThat(cars).hasSize(3);
        Assertions.assertThat(firstCar.getName()).isEqualTo("a");
        Assertions.assertThat(firstCar.getDistance()).isEqualTo(0);
    }

}