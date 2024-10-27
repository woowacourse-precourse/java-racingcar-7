package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Racing {
    private InputView inputView;
    private OutputView outputView;
    private RacingManager racingManager;

    public Racing(InputView inputView, OutputView outputView, RacingManager racingManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingManager = racingManager;
    }

    public void start(){
        List<Car>carList = initializeRace();
        int numberOfRounds = getValidatedNumberOfRounds();
        playRound(carList, numberOfRounds);
        displayResult(carList);
    }

    private int getValidatedNumberOfRounds() {
        outputView.requestNumberOfRoundsMessage();
        return inputView.getNumberOfRounds();
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
        return racingManager.parseCarNamesToCar(carNames);
    }
}
