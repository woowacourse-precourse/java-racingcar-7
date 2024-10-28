package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.input.InputProcessor;
import racingcar.output.OutputProcessor;

public class RacingCarService {
    private static RacingCarService instance;
    private final InputProcessor inputProcessor;
    private final OutputProcessor outputProcessor;
    private List<Car> cars;
    private int tryCount;

    private RacingCarService() {
        inputProcessor = InputProcessor.getInstance();
        outputProcessor = OutputProcessor.getInstance();
    }

    public static RacingCarService getInstance() {
        if (instance == null) {
            instance = new RacingCarService();
        }

        return instance;
    }

    public void run() {
        cars = inputProcessor.readCarList();
        tryCount = inputProcessor.readTryCount();

        startGame(tryCount);

        outputProcessor.printGameResult(getWinners());
    }

    private void startGame(int tryCount) {
        System.out.println("실행 결과");
        for (int round = 1; round <= tryCount; round++) {
            startRound();
        }
    }

    private void startRound() {
        cars.forEach(Car::moveOrStand);
        outputProcessor.printRoundResult(cars);
    }

    private List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
    }

    private int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }
}
