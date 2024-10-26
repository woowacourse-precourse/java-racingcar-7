package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final InputHandler inputHandler;
    private final GameView gameView;

    private List<Car> cars;
    private Integer roundCount;

    public Game(InputHandler inputHandler, GameView gameView) {
        this.inputHandler = inputHandler;
        this.gameView = gameView;
    }

    public void start() {
        gameView.printCarNameInputMessage();
        List<String> carNames = inputHandler.getCarNames();
        cars = createCars(carNames);

        gameView.printRoundCountInputMessage();
        roundCount = inputHandler.getRoundCount();

        gameView.printResultMessage();

        while (roundCount > 0) {
            List<String> roundResult = processRound();
            gameView.printRoundResult(roundResult);

            roundCount--;
        }

        List<String> winners = determineWinners();
        gameView.printWinner(winners);
    }

    private List<Car> createCars(List<String> names) {
        List<Car> result = new ArrayList<>();

        for (String name : names) {
            result.add(new Car(name));
        }

        return result;
    }

    private List<String> processRound() {
        List<String> result = new ArrayList<>();

        for (Car car : cars) {
            int power = RandomUtil.getRandomNumber();
            car.move(power);

            result.add(car.getInfo());
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
