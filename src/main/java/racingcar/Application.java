package racingcar;

import racingcar.game.Game;
import racingcar.io.InputManager;
import racingcar.name.Names;
import racingcar.car.Cars;

public class Application {
    public static void main(String[] args) {

        try {
            String input = InputManager.readInput();
            Names names = new Names(input);
            Cars cars = new Cars(names);

            int rounds = InputManager.readGameRound();

            Game.start(cars, rounds);
        } finally {
            InputManager.close();
        }

    }
}
