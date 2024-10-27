package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.util.CommonIo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private CarController carController = new CarController();
    private MoveController moveController = new MoveController();
    private PlayCountController playCountController = new PlayCountController();
    private CommonIo io = new CommonIo();

    public void run() {
        finishGame(playGame(prepareGame()));
    }

    public List<Car> prepareGame() {
        outputView.printGetCarNames();
        String carNameInput = inputView.receiveCarNames();
        List<String> carNames = carController.splitCarNames(carNameInput);
        List<Car> cars = carController.createAllCars(carNames);

        return cars;
    }

    public List<Car> playGame(List<Car> cars) {
        outputView.printGetPlayCount();
        int playCount = playCountController.validatePlayCount();

        for (int i = 0; i < playCount; i++) {
            playSingleRound(cars);
        }

        return cars;
    }

    public void finishGame(List<Car> cars) {
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
        Winner winner = new Winner();

        for (Car car : cars) {
            winner.comparePosition(car);
        }

        return winner.getWinners();
    }
}
