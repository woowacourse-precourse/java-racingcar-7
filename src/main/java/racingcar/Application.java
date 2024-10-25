package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = InputHandler.inputCars();
        int turns = InputHandler.inputTurns();

        Game game = new Game(cars, turns);
        game.play();

        List<String> winners = game.getWinners();
        OutputHandler.displayWinners(winners);
    }
}