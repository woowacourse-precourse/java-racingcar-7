package racingcar.controller;


import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        String names = inputView.readCarNames();
        Cars cars = new Cars(names);

        int attempts = getTryCount();
        outputView.printResultMessage();
        playGame(cars, attempts);
        announceWinners(cars);
    }

    private int getTryCount() {
        return inputView.readTryCount();
    }

    private void playGame(Cars cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            playSingleRound(cars);
        }
    }

    private void playSingleRound(Cars cars) {
        cars.moveAll();
        outputView.printRoundResult(cars.getCars());
        System.out.println();
    }

    private void announceWinners(Cars cars) {
        outputView.printWinners(cars.getWinners());
    }
}