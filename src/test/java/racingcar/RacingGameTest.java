package racingcar;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    void 자동차들이_이동한다() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        List<Car> cars = Arrays.asList(car1, car2);
        RacingGameView view = new RacingGameView();
        RacingGame game = new RacingGame(cars, 1, view);

        game.play();
        assertThat(car1.getPosition() >= 0).isTrue();
        assertThat(car2.getPosition() >= 0).isTrue();
    }

    @Test
    void 시도횟수만큼_실행된다() {
        Car car = new Car("pobi");
        List<Car> cars = Arrays.asList(car);
        RacingGameView view = new RacingGameView();
        RacingGame game = new RacingGame(cars, 3, view);

        game.play();
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(car.getPosition()).isLessThanOrEqualTo(3);
    }
}
