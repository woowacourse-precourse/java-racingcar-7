package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private Game game;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setup() {
        List<Car> carList = List.of(Car.create("aaa"), Car.create("bbb"));
        game = Game.carListFrom(carList);
    }

    @Test
    void playOneRound() {
        assertRandomNumberInRangeTest(
                () -> {
                    game.playOneRound();
                    assertThat(game.getCarList().getFirst().getMoveCnt()).isEqualTo(1);
                    assertThat(game.getCarList().getLast().getMoveCnt()).isEqualTo(0);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_한명_가져오기() {
        assertRandomNumberInRangeTest(
                () -> {
                    game.playOneRound();
                    assertThat(game.getWinners()).isEqualTo("aaa");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_두명_가져오기() {
        assertRandomNumberInRangeTest(
                () -> {
                    game.playOneRound();
                    assertThat(game.getWinners()).isEqualTo("aaa, bbb");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }
}