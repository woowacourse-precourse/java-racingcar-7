package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    private RacingCar racingCar;
    private List<Car> cars;
    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void beforeEach() {
        car1 = new Car("a");
        car2 = new Car("b");
        car3 = new Car("c");

        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        racingCar = new RacingCar(cars);
    }

    @Test
    void 단독_우승자_테스트() {
        car1.go(3);
        car2.go(4);
        car3.go(4);
        car3.go(5);
        assertThat(racingCar.findWinners()).contains(car3);
    }

    @Test
    void 공동_우승자_테스트() {
        car2.go(4);
        car2.go(5);
        car3.go(4);
        car3.go(5);
        assertThat(racingCar.findWinners()).contains(car2, car3);
    }
}