package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;

class CarServiceTest {

    private final CarService carService = new CarService();

    @Test
    @DisplayName("자동차 리스트 생성")
    void makeCars() {
        //given
        final List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        final CarNames carNames = new CarNames(names);

        //when
        final Cars cars = carService.createCars(carNames);

        //then
        assertThat(cars.getCars()).hasSize(3);
    }

}