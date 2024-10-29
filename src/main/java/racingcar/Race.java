package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.handler.InputHandler;
import racingcar.handler.OutputHandler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Race(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public List<Car> start() {
        List<Car> cars = inputHandler.carList();
        int tryCount = inputHandler.tryCount();

        performRace(tryCount, cars);
        return cars;
    }

    private void performRace(int tryCount, List<Car> cars) {
        IntStream.range(0, tryCount).forEach(i -> {
            progress(cars);
            outputHandler.printResults(cars);
        });
    }

    private void progress(List<Car> cars) {
        cars.stream()
                .filter(car -> shouldMove())
                .forEach(Car::move);
    }

    public void end(List<Car> cars) {
        outputHandler.printWinners(winner(cars));
    }

    private boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
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
