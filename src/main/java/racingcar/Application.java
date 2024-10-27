package racingcar;

import racingcar.controller.race.RaceController;
import racingcar.service.factory.RaceControllerFactory;
import racingcar.service.factory.RaceControllerFactoryEmb;

public class Application {
    public static void main(String[] args) {
        RaceControllerFactory raceControllerFactory = new RaceControllerFactoryEmb();
        RaceController raceController = raceControllerFactory.createRaceController();

        raceController.readyForRace();
        raceController.broadcastRace();
        raceController.announceWinner();
    }
}
