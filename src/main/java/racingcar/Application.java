package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            RacingGameService service = new RacingGameService();

            List<Car> cars = service.createCars();
            int attemptCount = service.getAttemptCount();

            Game game = new Game(cars, attemptCount);
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }    }
}
