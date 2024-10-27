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
    private CommonIo io = new CommonIo();
    private CarController carController = new CarController();
    private MoveController moveController = new MoveController();

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
        int playCount = validatePlayCount();

        for (int i = 0; i < playCount; i++) {
            for (Car car : cars) {
                int randomNumber = moveController.createRandomNumber();
                boolean isMove = moveController.isMove(randomNumber);
                if (isMove) {
                    moveController.setMoveInformation(car);
                }
                outputView.printSingleResult(car);
            }
        }

        return cars;
    }

    public void finishGame(List<Car> cars) {
        List<String> winner = selectWinners(cars);
        outputView.printWinners(winner);
    }

    public int validatePlayCount() {
        outputView.printGetPlayCount();
        int playCount;

        try {
            playCount = io.convertStringToInt(inputView.receivePlayCount());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PLAY_COUNT_FORMAT.getError());
        }

        if (playCount < Limit.MIN_PLAY.getValue() || playCount > Limit.MAX_PLAY.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.PLAY_COUNT_LIMIT.getError());
        }

        return playCount;
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
