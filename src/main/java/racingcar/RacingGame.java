package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.randomNumberGenerator();

    public RacingGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Cars cars = new Cars(inputView.inputCarNameGuide());
        int round = inputView.inputRound();
        resultView.printResult();
        for(int i = 0; i < round; i++) {
            playRound(cars);
        }
        resultView.printWinners(cars.getWinners());
    }

    private void playRound(Cars cars) {
        cars.tryMove(randomNumberGenerator);
        resultView.printAllLocations(cars);
    }

}
