package service;

import model.Car;
import model.Cars;
import util.randomnumber.RandomNumberHandler;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {
    private final RandomNumberHandler randomNumberHandler;
    private final OutputView outputView;

    public RacingGameService(RandomNumberHandler randomNumberHandler, OutputView outputView) {
        this.randomNumberHandler = randomNumberHandler;
        this.outputView = outputView;
    }

    public void startRace(Cars cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveAllCars(cars);
            outputView.printCurrentStatus(cars);
        }
    }

    private void moveAllCars(Cars cars) {
        for (Car car : cars.getCars()) {
            if (randomNumberHandler.canMove()) {
                car.moveForward();
            }
        }
    }

    public List<String> getWinners(Cars cars) {
        int maxPosition = cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
