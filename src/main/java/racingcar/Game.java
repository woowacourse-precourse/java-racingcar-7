package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private Cars cars;
    private Rounds rounds;

    public Game(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void start() {
        List<String> carNames = inputHandler.getCarNames();
        cars = new Cars(carNames);

        String roundSizeInput = inputHandler.getRoundSize();
        rounds = new Rounds(roundSizeInput);

        outputHandler.printResultMessage();
        rounds.proceedRounds(cars.getCars(), outputHandler);

        List<String> winners = determineWinners();
        outputHandler.printWinner(winners);
    }

    private List<String> determineWinners() {
        List<String> winners = new ArrayList<>();

        int maxDistance = cars.getCars().stream()
                .mapToInt(Car::getDistance)
                .max().orElse(0);

        return cars.getCars().stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName).toList();
    }
}
