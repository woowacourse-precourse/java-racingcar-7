package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.car.Car;
import racingcar.domain.car.Condition;
import racingcar.domain.car.RandomNumberGenerator;
import racingcar.domain.round.RoundResult;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<String> carNames = inputView.showGetCarNamesInput();
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName, new Condition(new RandomNumberGenerator())))
                .toList();

        int finalRound = inputView.showGetFinalRoundInput();
        RacingGame racingGame = new RacingGame(cars, finalRound);

        outputView.showPlayGame();
        while (racingGame.isNotGameOver()) {
            racingGame.playNextRound();
            outputView.showRacingResult(racingGame.getRacingResult());
        }
        outputView.showFinalWinners(racingGame.getFinalWinners());
    }

}
