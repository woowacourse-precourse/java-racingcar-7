package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.Cars;
import racingcar.model.domain.GameResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GameResultTest {

    @Test
    void 라운드결과를_게임결과에_기록하다() {
        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new TestNumberGenerator(List.of(3, 4)));
        cars.moveForward();

        gameResult.recordRound(cars);

        assertThat(gameResult.getRoundResults()).hasSize(1);
    }

    @Test
    void 우승자를_게임결과에_기록하다() {
        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new TestNumberGenerator(List.of(3, 4, 4, 4)));
        Cars movedCars = cars.moveForward()
                .moveForward();

        gameResult.recordWinner(movedCars);

        assertEquals("woni", gameResult.getWinners().getFirst());
    }
}
