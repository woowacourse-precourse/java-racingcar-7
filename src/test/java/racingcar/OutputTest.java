package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGameController;
import racingcar.model.Cars;
import racingcar.model.RaceRound;
import racingcar.model.RacingGame;
import racingcar.view.OutputView;

public class OutputTest {
    private static final String CAR_NAMES = "emily, tomas, gina";
    private static Cars cars;
    private RaceRound round;

    @BeforeEach
    void 게임세팅() {
        cars = new Cars();

        cars.addCarFromString(CAR_NAMES);
        round = new RaceRound(2, cars);
    }

    @Test
    void 라운드_출력_테스트() {
        RacingGame racingGame = new RacingGame(cars, round);

        cars.getCarList().forEach(car -> car.moveIfTrue(5));
        round.saveRoundResult(cars);

        OutputView.roundResult(round.toStringRoundResult());
        assertEquals("emily: -----\ntomas: -----\ngina: -----\n", round.toStringRoundResult());
    }

    @Test
    void 우승자_출력_테스트() {
        RacingGameController controller = new RacingGameController();
        RacingGame racingGame = new RacingGame(cars, round);

        cars.getCarList().forEach(car -> car.moveIfTrue(5));
        round.saveRoundResult(cars);

        Cars finalRoundCars = round.getThisRoundCars();
        Cars winnerCars = finalRoundCars.sortWinnerCars();

        controller.endGame(finalRoundCars);

        assertEquals("emily, tomas, gina", winnerCars.toStringWinnerCars(winnerCars));
    }
}
