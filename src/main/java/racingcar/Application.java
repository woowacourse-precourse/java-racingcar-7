package racingcar;

public class Application {
    public static void main(String[] args) {

        try {
            String name = InputManager.readInput();
            int rounds = InputManager.readGameRound();

            Names names = new Names(name);
            Cars cars = new Cars(names);

            Game.start(cars, rounds);
        } finally {
            InputManager.close();
        }

    }
}
