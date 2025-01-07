package racingcar;

import static racingcar.Car.createDefaultCar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    private Racing racing;

    @BeforeEach
    void setUp() {

    }

    @DisplayName("우승자를 정확히 구하는지 확인한다")
    @Test
    void racingTest1() {
        List<Car> cars = new ArrayList<>();
        Car car1 = createDefaultCar("Car1");
        Car car2 = createDefaultCar("Car2");
        Car car3 = createDefaultCar("Car3");
        car1.move(Car.MINIMUM_MOVE_VALUE);
        car2.move(Car.MINIMUM_MOVE_VALUE);
        car3.move(Car.MINIMUM_MOVE_VALUE - 1);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        racing = new Racing(cars, 5);

        List<String> winners = racing.findWinners();
        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners.get(0)).isEqualTo("Car1");
        Assertions.assertThat(winners.get(1)).isEqualTo("Car2");
    }

}