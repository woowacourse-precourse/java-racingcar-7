package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private ArrayList<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("player1"));
        cars.add(new Car("player2"));
        cars.add(new Car("player3"));
    }

    @Test
    public void 경기_종류_후_우승자는_1명_이상() {
        RacingGame racingGame = new RacingGame(cars, 5);

        List<String> winners = racingGame.race();

        Assertions.assertThat(winners.isEmpty()).isFalse();
    }
}