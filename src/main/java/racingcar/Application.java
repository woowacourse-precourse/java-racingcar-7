package racingcar;

import racingcar.car.CarFactory;
import racingcar.car.Cars;
import racingcar.io.InputHandler;
import racingcar.race.Race;
import racingcar.race.RaceController;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController(
                new InputHandler(),
                new Race(),
                new Cars(),
                new CarFactory()
        );
        raceController.runRace();
    }
}
