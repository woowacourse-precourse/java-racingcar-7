package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    public void run() {
        String[] carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            ResultView.printProgress(cars);
        }

        List<String> winners = getWinners(cars);
        ResultView.printWinners(winners);
    }

    private List<String> getWinners(List<Car> cars) {
                int maxPosition = 0;
                for (Car car : cars) {
                    if (car.getPosition() > maxPosition) {
                        maxPosition = car.getPosition();
                    }
                }

                List<String> winners = new ArrayList<>();
                for (Car car : cars) {
                    if (car.getPosition() == maxPosition) {
                  winners.add(car.getName());
            }
        }
        return winners;
    }
}