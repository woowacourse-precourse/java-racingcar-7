package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * GameTest
 */
public class GameTest {

    private final static int MOVE = 9;
    private final static int STOP = 0;

    @Test
    void set_cars() {
        Game game = new Game();

        game.addCar("pobi");
        game.addCar("woni");
        game.addCar("jun");

        assertThat(game.getCars()).size().isEqualTo(3);
    }

    @Test
    void move_cars() {
        Game game = new Game();
        game.addCar("pobi");
        game.addCar("woni");
        game.addCar("jun");

        assertRandomNumberInRangeTest(() -> {
            game.progress();
            game.progress();
            game.progress();
        },
            MOVE, MOVE, STOP,
            MOVE, MOVE, STOP,
            MOVE, MOVE, STOP
        );

        List<Car> cars = game.getCars();
        assertThat(cars.get(0).getProgress()).isEqualTo(3);
        assertThat(cars.get(1).getProgress()).isEqualTo(3);
        assertThat(cars.get(2).getProgress()).isEqualTo(0);
    }

    @Test
    void find_winners() {
        Game game = new Game();
        game.addCar("pobi");
        game.addCar("woni");
        game.addCar("jun");

        assertRandomNumberInRangeTest(() -> {
            game.progress();
            game.progress();
            game.progress();
        },
            MOVE, MOVE, STOP,
            MOVE, MOVE, STOP,
            MOVE, MOVE, STOP
        );

        List<Car> winners = game.getWinners();
        assertThat(winners).size().isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
        assertThat(winners.get(1).getName()).isEqualTo("woni");
    }
}
