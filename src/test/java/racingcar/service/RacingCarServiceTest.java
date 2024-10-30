package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RacingCarServiceTest {

    CarService carService = RacingCarService.getInstance();

    @Test
    @DisplayName("자동차 등록 테스트")
    void register() {

        Car car = new Car("pobi");
        carService.register(car);

        Car findCar = carService.getAllCars().get(0);
        Assertions.assertThat(findCar.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("모든 자동차 조회 테스트")
    void getAllCars() {

        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        carService.register(car1);
        carService.register(car2);
        carService.register(car3);

        Assertions.assertThat(carService.getAllCars().size()).isEqualTo(3);
    }
}