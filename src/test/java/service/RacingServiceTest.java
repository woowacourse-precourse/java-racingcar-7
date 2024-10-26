package service;

import static org.assertj.core.api.Assertions.*;

import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingServiceTest {
    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
    }

    @Test
    @DisplayName("정확한 자동차 목록을 반환")
    void checkGetExactCarsList() {
        String input = "c1,c2,c3";
        Car car1 = new Car("c1");
        Car car2 = new Car("c2");
        Car car3 = new Car("c3");

        Cars cars = new Cars(input);

        assertThat(cars.getCarsList())
                .hasSize(3)
                .contains(car1, car2, car3);
    }

    @Test
    @DisplayName("자동차가 랜덤 값에 따라 전진을 성공했는지 확인")
    void checkCarsMovement() {
        Car car = new Car("c1");

        int randomValue1 = 4;
        int randomValue2 = 3;

        car.moveOrStop(randomValue1);
        assertThat(car.getScore()).isEqualTo(1);
        car.moveOrStop(randomValue2);
        assertThat(car.getScore()).isEqualTo(1);
    }

}