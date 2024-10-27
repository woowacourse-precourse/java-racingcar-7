package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.UserInputDto;
import racingcar.model.Car;
import racingcar.view.OutputView;

public class CarRace {

    private List<Car> cars;
    private OutputView outputView = new OutputView();

    public List<String> start(int trialCount) {

        for (int i = 0; i < trialCount; i++) {
            for (Car car : cars) {
                car.go();
            }
            outputView.printRaceStatus(cars);
        }

        return findWinners();
    }

    private List<String> findWinners() {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    public CarRace(List<Car> cars) {
        this.cars = cars;
    }
}
