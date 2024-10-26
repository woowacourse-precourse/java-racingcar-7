package racingcar;


import racingcar.controller.RaceController;
import racingcar.controller.RaceControllerEmb;
import racingcar.service.RaceControllerFactory;
import racingcar.service.RaceControllerFactoryEmb;

public class Application {
    public static void main(String[] args) {
        RaceControllerFactory raceControllerFactory = new RaceControllerFactoryEmb();
        RaceController raceController = raceControllerFactory.createRaceController();

        raceController.readyForRace();
        while (!raceController.isFinished()) {
            raceController.advanceCars();
        }
        raceController.presentAward();
    }
}
