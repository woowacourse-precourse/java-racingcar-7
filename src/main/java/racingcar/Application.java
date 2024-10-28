package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();

        List<String> carNames = input.getCarNames();
        int gameCount = input.getGameCount();

        Cars cars = new Cars(carNames);

        Game game = new Game(cars, gameCount);

        game.playGame();
    }
}
