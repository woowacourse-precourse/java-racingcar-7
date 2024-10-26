package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerTest {

    @Test
    void 단독_우승_테스트() {
        Car car1 = new Car("도현");
        Car car2 = new Car("현도");
        car1.increaseDistance();

        Winner winner = new Winner(List.of(car1, car2));

        assertThat(winner.getWinningCars()).isEqualTo(List.of(car1.getName()));
    }

    @Test
    void 공동_우승_테스트() {
        Car car1 = new Car("도현");
        Car car2 = new Car("현도");
        Car car3 = new Car("꼴지");
        car1.increaseDistance();
        car2.increaseDistance();

        Winner winner = new Winner(List.of(car1, car2, car3));

        assertThat(winner.getWinningCars()).isEqualTo(List.of(car1.getName(), car2.getName()));
    }
}
