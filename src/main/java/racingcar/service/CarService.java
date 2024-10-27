package racingcar.service;

import racingcar.config.GameConfig;
import racingcar.message.OutputMessage;
import racingcar.model.Car;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.WinnerCalculator;
import racingcar.validation.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class CarService {

    private final InputView inputView;
    private final OutputView outputView;

    public CarService(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public GameConfig initializeGame() {
        String inputCarName = inputView.inputCarName();

        List<String> carNames = Arrays.asList(inputCarName.split(","));
        Validator.checkDuplicateNames(carNames);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        int attemptCount = inputView.getAttemptCount();
        return new GameConfig(cars, attemptCount);
    }

    public void startRace(List<Car> cars, int count) {
        System.out.println(OutputMessage.RESULT.getMessage());

        for (int i = 0; i < count; i++) {
            cars.forEach(car -> car.move(RandomNumberGenerator.move()));
            outputView.racingView(cars);
        }
    }

    public void showResults(List<Car> cars){
        List<String> winnerCarList = WinnerCalculator.calculateWinners(cars);
        outputView.resultView(winnerCarList);
    }

}
