package racingcar.controller;

import racingcar.Validator;
import racingcar.model.Car;
import racingcar.model.RacingManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Racing {
    private InputView inputView;
    private OutputView outputView;
    private RacingManager racingManager;
    private Validator validator;

    public Racing(InputView inputView, OutputView outputView, RacingManager racingManager, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingManager = racingManager;
        this.validator = validator;
    }

    public void start(){
        List<Car>carList = initializeRace();
        int numberOfRounds = getValidatedNumberOfRounds();
        playRound(carList, numberOfRounds);
        displayResult(carList);
    }

    private int getValidatedNumberOfRounds() {
        outputView.requestNumberOfRoundsMessage();
        String numberOfRounds = inputView.getNumberOfRounds();
        validator.isValidNumberOfRounds(numberOfRounds);
        return Integer.parseInt(numberOfRounds);
    }

    private void displayResult(List<Car> carList) {
        outputView.displayWinners(racingManager.getWinners(carList));
    }

    private void playRound(List<Car> carList, int numberOfRounds) {
        for(int i = 0; i<numberOfRounds; i++){
            racingManager.moveOrStop(carList);
        }
        outputView.displayRaceProgress(carList);
    }

    private List<Car> initializeRace() {
        outputView.requestCarNameMessage();
        String carNames = inputView.getCarNames();
        validator.isValidCarNames(carNames);
        return racingManager.parseCarNamesToCar(carNames);
    }
}
