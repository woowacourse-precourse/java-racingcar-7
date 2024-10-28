package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<Car> cars;

    public void start(){
        String carNames = inputView.getCarNames();
        int rounds = inputView.getRounds();

        cars = createCars(carNames);

        for (int i = 0; i < rounds; i++) {
            moveCars();
            outputView.displayRoundResults(cars);
        }
        outputView.displayWinners(getWinners());
    }

    private List<Car> createCars(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNameArray) {
            String trimmedName = carName.trim();
            if(trimmedName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
