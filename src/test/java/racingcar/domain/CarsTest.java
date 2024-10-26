package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
    @Test
    void 전체_자동차_이동 () {
        Car car1 = new TestCar("pobi", true);
        Car car2 = new TestCar("woni", false);
        Car car3 = new TestCar("jun", true);

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        cars.moveAll();

        List<Car> movedCars = cars.getCars();

        assertThat(movedCars)
                .extracting(Car::getPosition)
                .containsExactly(1, 0, 1);
    }

    @Test
    void 최대값_구하기 () {
        Car car1 = new TestCar("pobi", true);
        Car car2 = new TestCar("woni", false);
        Car car3 = new TestCar("jun", true);

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        int moveCount = 5;
        IntStream.range(0, moveCount).forEach(i -> cars.moveAll());

        assertThat(cars.getMaxPosition()).isEqualTo(moveCount);
    }

    @Test
    void 승자_구하기 () {
        Car car1 = new TestCar("pobi", true);
        Car car2 = new TestCar("woni", false);
        Car car3 = new TestCar("jun", true);

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        int moveCount = 5;
        IntStream.range(0, moveCount).forEach(i -> cars.moveAll());

        assertThat(cars.findWinners())
                .extracting(Car::getName)
                .containsExactly("pobi", "jun");
    }
}
