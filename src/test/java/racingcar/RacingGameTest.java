package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class RacingGameTest {

    @Test
    void 주어진_횟수_만큼_전진_조건을_실행하는지_테스트() {
        RacingGame racingGame = new RacingGame();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        int attemptCount = 3;

        racingGame.playRace(cars, attemptCount, 4);

        assertThat(cars.get(0).getPosition()).isEqualTo(3);
    }
}
