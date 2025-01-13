package controller;

import racingcar.AttemptCount;
import racingcar.Cars;
import racingcar.Racing;
import util.NumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run(NumberGenerator numberGenerator) {
        Racing racing = createRacing();
        playAllRacing(racing, AttemptCount.from(inputView.inputAttemptCount()), numberGenerator);
        printWinner(racing);
    }

    private Racing createRacing() {
        String carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames);
        return new Racing(cars);
    }

    private void playAllRacing(Racing racing, int attemptCount, NumberGenerator numberGenerator) {
        outputView.printf("%n실행 결과%n");
        for (int i = 0; i < attemptCount; i++) {
            racing.playRacing(numberGenerator);
            racing.getCarList().forEach(car ->
                    outputView.printRacing(car.getName(), car.getPosition()));
            outputView.printf("%n");
        }
    }

    private void printWinner(Racing racing) {
        outputView.finalWinners(racing.findWinners());
    }
}
