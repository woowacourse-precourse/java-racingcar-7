package racingcar.controller;

import racingcar.domain.Car;
import racingcar.global.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        String carName = inputView.getRacingCarName();
        int tryCount = inputView.getTrial();
        List<String> carNames = inputView.changeStringToList(carName);
        List<Car> cars = setCars(carNames);
        race(tryCount, cars);
        outputView.printWinners(getMaxPosition(cars), cars);
    }

    public int getMaxPosition(final List<Car> cars) {
        System.out.print(Message.WINNER.getMessage());
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public void race(int tryCount, final List<Car> cars) {
        System.out.println();
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            outputView.printCurrentCarPositions(cars);
        }
    }

    public List<Car> setCars(final List<String> input) {
        List<Car> cars = new ArrayList<>();
        for (String name : input) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
