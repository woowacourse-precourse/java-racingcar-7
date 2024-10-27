package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 최대_이동거리_테스트() {
        Car car1 = new Car("hhj", 4);
        Car car2 = new Car("hizxang", 3);
        Car car3 = new Car("mongle", 1);
        // Max Location = 4

        List<Car> carList = Arrays.asList(car1, car2, car3);
        Cars cars = new Cars(carList);

        assertThat(cars.getMaxLocation()).isEqualTo(4);
    }

    @Test
    void 우승자_찾기_테스트() {

        Car car1 = new Car("hhj", 4);
        // car1 is winner
        Car car2 = new Car("hizxang", 4);
        // car2 is winner
        Car car3 = new Car("mongle", 1);
        Car car4 = new Car("monsil", 2);

        List<Car> carList = Arrays.asList(car1, car2, car3, car4);
        List<Car> winnerList = Arrays.asList(car1, car2);
        Cars cars = new Cars(carList);

        assertThat(cars.findWinner()).isEqualTo(winnerList);
    }
}
