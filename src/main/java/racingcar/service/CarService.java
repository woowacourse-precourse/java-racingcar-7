package racingcar.service;

import racingcar.config.GameConfig;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    private final InputView inputView;
    private final OutputView outputView;

    public CarService(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public GameConfig initializeGame() {
        String inputCarName = inputView.inputCarName();
        List<Car> cars = Arrays.stream(inputCarName.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
        int attemptCount = inputView.getAttemptCount();
        return new GameConfig(cars, attemptCount);
    }

    public void startRace(List<Car> cars, int count) {
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            cars.forEach(Car::move);
            outputView.racingView(cars);
        }
    }

    public void showResults(List<Car> cars){
        List<String> winnerCarList = getWinners(cars);
        outputView.resultView(winnerCarList);
    }

    private List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName).toList();
    }
}
