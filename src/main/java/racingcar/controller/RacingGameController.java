package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private RacingGame racingGame;
    private OutputView outputView;

    public RacingGameController() {
        outputView = new OutputView();
    }

    public void start() {
        List<Car> cars = inputCarNames();
        int trialCount = inputTrialCount();

        racingGame = new RacingGame(cars, trialCount);
        playGame();
    }

    private List<Car> inputCarNames() {
        String carNames = InputView.inputCarNames();
        InputValidator.validateCarNames(carNames); // 자동차 이름 검증
        String[] names = carNames.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim())); // 공백 제거 후 추가
        }
        return cars;
    }

    private int inputTrialCount() {
        int trialCount = InputView.inputTrialCount();
        InputValidator.validateTrialCount(trialCount); // 시도 횟수 검증
        return trialCount;
    }

    private void playGame() {
        while (racingGame.hasMoreTrials()) {
            racingGame.playRound();
            outputView.printRoundResult(racingGame.getCars());
        }
        outputView.printWinners(racingGame.getWinners());
    }
}
