package racingcar.manager;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.config.GameConstant.MOVEMENT_THRESHOLD;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.entity.Car;

class GameManagerTest {
    GameManager gameManager;
    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @Test
    void 단일_우승자_판정() {
        Car winner = new Car("winner");
        winner.moveCar(MOVEMENT_THRESHOLD);
        Car loser = new Car("loser");
        List<Car> cars = List.of(winner, loser);

        List<Car> winners = gameManager.judgeWinner(cars);

        assertThat(winners).containsExactly(winner);
    }

    @Test
    void 중복_우승자_판정() {
        Car winner1 = new Car("winner1");
        Car winner2 = new Car("winner2");

        List<Car> cars = List.of(winner1, winner2);

        List<Car> winners = gameManager.judgeWinner(cars);

        assertThat(winners).containsExactly(winner1, winner2);
    }
}