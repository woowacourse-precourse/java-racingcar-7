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

    }

    private List<Car> createCar(List<String> names) {
        return new ArrayList<>();
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

    private List<Car> determineWinners() {
        return new ArrayList<>(cars);
    }
}
