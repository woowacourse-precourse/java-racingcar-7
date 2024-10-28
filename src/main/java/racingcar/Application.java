package racingcar;


import racingcar.controller.RaceGameController;
import racingcar.model.Cars;
import racingcar.model.Move;
import racingcar.model.RaceGame;


public class Application {
    public static void main(String[] args) {
        final Cars cars = new Cars();
        final Move move = new Move();
        final RaceGame raceGame = new RaceGame(move);

        final RaceGameController raceController = new RaceGameController(cars, raceGame);

        raceController.run();
    }




}
