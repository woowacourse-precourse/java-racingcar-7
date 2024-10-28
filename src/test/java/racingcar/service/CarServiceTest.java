package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    @DisplayName("새로운 자동차 목록을 추가할 수 있어야 한다.")
    void addCars() {
        ArrayList<Car> newCars = new ArrayList<>();
        newCars.add(new Car("carA"));
        newCars.add(new Car("carB"));

        carService.addCars(newCars);

        assertThat(carService.getCars()).containsExactlyElementsOf(newCars);
    }
}