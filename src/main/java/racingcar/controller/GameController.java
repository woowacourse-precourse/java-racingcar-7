package racingcar.controller;

import static racingcar.util.InputValidator.validateNoDuplicates;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.RandomUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;

    public GameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        List<Car> cars = initGame();
        startGame(cars);
    }

    private void startGame(List<Car> cars) {
        int totalRoundCount = getTotalRoundCount();

        outputView.printRunResult();
        for (int round = 0; round < totalRoundCount; round++) {
            playRound(cars);
            outputView.printRoundResult(cars);
        }
    }

    private int getTotalRoundCount() {
        return inputView.inputPlayCount();
    }

    private void playRound(List<Car> cars) {
        cars.forEach(car -> {
            int randomNumber = RandomUtil.generateRandomNumber();
            car.moveForward(randomNumber);
        });
    }

    private List<Car> initGame() {
        List<String> carList = getCarNames();
        validateNoDuplicates(carList);

        return createCars(carList);
    }

    private List<String> getCarNames() {
        String inputCarsName = inputView.inputCarsName();
        return Arrays.asList(inputCarsName.split(","));
    }

    private List<Car> createCars(List<String> carList) {
        return carList.stream()
                .map(Car::new)
                .toList();
    }
}
