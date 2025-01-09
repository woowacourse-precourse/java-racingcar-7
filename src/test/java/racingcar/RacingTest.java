package racingcar;

import static racingcar.Car.createDefaultCar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.FakeGenerator;

class RacingTest {

    private Racing racing;

    @DisplayName("우승자를 정확히 구하는지 확인한다")
    @Test
    void racingTest1() {
        List<Car> cars = new ArrayList<>();
        Car car1 = createDefaultCar("Car1", new FakeGenerator(100));
        Car car2 = createDefaultCar("Car2", new FakeGenerator(2));
        Car car3 = createDefaultCar("Car3", new FakeGenerator(3));
        car1.move();
        car2.move();
        car3.move();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        racing = new Racing(cars);

        List<String> winners = racing.findWinners();
        Assertions.assertThat(winners.size()).isEqualTo(1);
        Assertions.assertThat(winners.get(0)).isEqualTo("Car1");
    }

}
