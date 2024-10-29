package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.Cars;
import racingcar.model.domain.GameResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GameResultTest {

    @Test
    void 라운드_결과_저장테스트() {
        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new NumberGeneratorTest(List.of(3, 4)));
        cars.moveForward();

        gameResult.saveRound(cars);

        assertThat(gameResult.getRoundResults()).hasSize(1);
    }

    @Test
    void 최종우승자_결정테스트() {
        GameResult gameResult = new GameResult();
        Cars cars = Cars.from(List.of("pobi", "woni"), new NumberGeneratorTest(List.of(3, 4, 4, 4)));
        Cars movedCars = cars.moveForward()
                .moveForward();

        gameResult.saveWinner(movedCars);

        assertEquals("woni", gameResult.getWinners().getFirst());
    }
}
