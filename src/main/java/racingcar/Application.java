package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        try {
            List<Name> names = InputManager.getInput();
            int rounds = InputManager.getGameRound();

            Cars cars = new Cars(names);

            Game.start(cars, rounds);
        } finally {
            InputManager.close();
        }

    }
}
