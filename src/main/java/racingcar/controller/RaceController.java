package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.CommonIo;
import racingcar.util.ErrorMessage;
import racingcar.util.Limit;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private CarController carController = new CarController();
    private MoveController moveController = new MoveController();
    private PlayCountController playCountController = new PlayCountController();

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
    }

    private void performSingleMove(Car car) {
        int randomNumber = moveController.createRandomNumber();
        if (moveController.isMove(randomNumber)) {
            moveController.setMoveInformation(car);
        }
    }

    public List<String> selectWinners(List<Car> cars) {
        int maxPosition = Limit.MIN_POSITION.getValue();
        List<String> winner = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                winner.clear();
                winner.add(car.getName());
                maxPosition = car.getPosition();
            } else if (car.getPosition() == maxPosition) {
                winner.add(car.getName());
            }
        }

        return winner;
    }
}
