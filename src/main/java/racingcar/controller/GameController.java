package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    public void run() {
        List<Car> cars = initCars();
        playRace(cars);
        List<String> winners = getWinners(cars);
        ResultView.printWinners(winners);
    }

    private List<Car> initCars() {
        String[] carNames = InputView.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void playRace(List<Car> cars) {
        int tryCount = InputView.getTryCount();
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            ResultView.printProgress(cars);
        }
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