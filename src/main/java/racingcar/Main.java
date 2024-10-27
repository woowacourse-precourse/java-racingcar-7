package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.CarController;
import racingcar.controller.MoveController;
import racingcar.util.CommonIo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private CommonIo io = new CommonIo();
    private CarController carController = new CarController();
    private MoveController moveController = new MoveController();

    public void run(){
        finishGame(playGame(prepareGame()));
    }

    public List<Car> prepareGame() {
        outputView.printGetCarNames();
        String carNameInput = inputView.receiveCarNames();
        List<String> carNames = splitCarNames(carNameInput);
        List<Car> cars = carController.createAllCars(carNames);

        return cars;
    }

    public List<Car> playGame(List<Car> cars) {
        outputView.printGetPlayCount();
        int playCount = io.convertStringToInt(inputView.receivePlayCount());

        for (int i = 0; i < playCount; i++) {
            for (Car car : cars) {
                int randomNumber = moveController.createRandomNumber();
                boolean isMove = moveController.isMove(randomNumber);
                if(isMove) {
                    moveController.setMoveInformation(car);
                }
                outputView.printSingleResult(car);
            }
        }

        return cars;
    }

    public void finishGame(List<Car> cars) {
        outputView.printWinners(cars);
    }

    public List<String> splitCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        return carNames;
    }

}
