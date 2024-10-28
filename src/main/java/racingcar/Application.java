package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        startRacingGame();
    }

    private static void startRacingGame() {
        try {
            List<Car> cars = RacingGame.initializeCars();
            int rounds = RacingGame.initializeRounds();
            RacingGame game = new RacingGame(cars, rounds);
            game.startRace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
