package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.controller.InputController;
import racingcar.controller.RaceController;
import racingcar.domain.CarDomain;
import racingcar.domain.RaceDomain;

public class Application {
    public static void main(String[] args) {
        InputController consoleController = new InputController();
        RaceController raceController = new RaceController();

        List<CarDomain> cars = consoleController.getCarNameRequest();
        int round = consoleController.getRoundRequest();

        RaceDomain race = raceController.getRaceRequest(cars, round);
        raceController.executeRaceRequest(race);
        raceController.getWinnerRequest(race);

        Console.close();
    }
}
