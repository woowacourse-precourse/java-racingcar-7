package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Race(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public List<Car> startRace() {
        List<Car> cars = inputHandler.carList();
        int tryCount = inputHandler.tryCount();

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                if (shouldMove()) {
                    car.move();
                }
            }
            outputHandler.printResults(cars);
        }
        return cars;
    }

    public void endRace(List<Car> cars) {
        List<Car> winners = winner(cars);
        outputHandler.printWinners(winners);
    }

    private boolean shouldMove() {
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= 4;
    }

    private List<Car> winner(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }
}
