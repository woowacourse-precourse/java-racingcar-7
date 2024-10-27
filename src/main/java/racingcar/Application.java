package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            startRacingGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void startRacingGame() {
        List<Car> cars = RacingGame.initializeCars();
        int rounds = RacingGame.initializeRounds();
        RacingGame game = new RacingGame(cars, rounds);
        game.startRace();
    }
}