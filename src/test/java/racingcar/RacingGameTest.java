package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

class RacingGameTest {

    @Test
    void 우승자_확인() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        car1.move(4);
        car1.move(4);
        car2.move(3);
        car3.move(4);

        List<Car> cars = Arrays.asList(car1, car2, car3);
        RacingGame game = new RacingGame(cars, 5);

        List<Car> winners = game.getWinners();
        assertThat(winners).containsExactlyInAnyOrder(car1, car3);
    }
}
