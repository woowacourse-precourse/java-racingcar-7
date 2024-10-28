package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.util.CommonIo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarController carController;
    private final MoveController moveController;
    private final PlayCountController playCountController;
    private final CommonIo io;

    private RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carController = new CarController();
        this.moveController = new MoveController();
        this.playCountController = PlayCountController.getInstance();
        this.io = new CommonIo();
    }

    public static RaceController getInstance() {
        return new RaceController();
    }

    public void run() {
        finishGame(playGame(prepareGame()));
    }

    private List<Car> prepareGame() {
        outputView.printGetCarNames();
        String carNameInput = inputView.receiveCarNames();
        List<String> carNames = carController.splitCarNames(carNameInput);

        return carController.createAllCars(carNames);
    }

    private List<Car> playGame(List<Car> cars) {
        outputView.printGetPlayCount();
        int playCount = playCountController.validatePlayCount();

        for (int i = 0; i < playCount; i++) {
            playSingleRound(cars);
        }

        return cars;
    }

    private void finishGame(List<Car> cars) {
        List<String> winner = selectWinners(cars);
        outputView.printWinners(winner);
    }

    private void playSingleRound(List<Car> cars) {
        for (Car car : cars) {
            performSingleMove(car);
            outputView.printSingleResult(car);
        }
        io.printNewLine();
    }

    private void performSingleMove(Car car) {
        int randomNumber = moveController.createRandomNumber();
        if (moveController.isMove(randomNumber)) {
            moveController.setMoveInformation(car);
        }
    }

    public List<String> selectWinners(List<Car> cars) {
        Winner winner = Winner.createWinner();

        for (Car car : cars) {
            winner.comparePosition(car);
        }

        return winner.getWinners();
    }
}
