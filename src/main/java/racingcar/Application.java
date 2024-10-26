package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.InputController;
import racingcar.controller.RaceController;
import racingcar.domain.CarDomains;
import racingcar.domain.RaceDomain;

public class Application {
    public static void main(String[] args) {
        InputController consoleController = new InputController();
        RaceController raceController = new RaceController();

        CarDomains cars = consoleController.getCarNameRequest();
        int round = consoleController.getRoundRequest();

        RaceDomain race = raceController.getRaceRequest(cars, round);
        raceController.executeRaceRequest(race);
        raceController.getWinnerRequest(race);

        Console.close();
    }
}
