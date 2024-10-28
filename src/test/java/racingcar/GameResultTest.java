package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.Cars;
import racingcar.model.domain.GameResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GameResultTest {

    @Test
    void 라운드결과_저장() {
        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new NumberGeneratorTest(List.of(5, 4)));
        cars.moveForward();

        gameResult.saveRound(cars);

        assertThat(gameResult.getRoundResults()).hasSize(1);
    }

    @Test
    void 우승자_저장() {
        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new NumberGeneratorTest(List.of(4, 7, 8, 3)));
        Cars movedCars = cars.moveForward()
                .moveForward();

        gameResult.saveWinner(movedCars);

        assertEquals("woni", gameResult.getWinners().getFirst());
    }
}
