package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private List<Car> cars;
    private Rounds rounds;

    public Game(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void start() {
        List<String> carNames = inputHandler.getCarNames();
        cars = createCars(carNames);

        Integer roundSize = inputHandler.getRoundSize();
        rounds = new Rounds(roundSize);

        outputHandler.printResultMessage();
        rounds.proceedRounds(cars, outputHandler);

        List<String> winners = determineWinners();
        outputHandler.printWinner(winners);
    }

    private List<Car> createCars(List<String> names) {
        List<Car> result = new ArrayList<>();

        for (String name : names) {
            result.add(new Car(name));
        }

        return result;
    }

    private List<String> determineWinners() {
        List<String> winners = new ArrayList<>();

        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max().orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName).toList();
    }
}
