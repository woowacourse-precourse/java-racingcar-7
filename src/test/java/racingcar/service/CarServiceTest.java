package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
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
        assertThat(cars).hasSize(3);
        assertThat(cars.getFirst().getName()).isEqualTo("a");
        assertThat(cars.getFirst().getDistance()).isEqualTo(0);
    }

}