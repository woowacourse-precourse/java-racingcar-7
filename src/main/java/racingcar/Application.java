package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.controller.InputController;
import racingcar.controller.RaceController;
import racingcar.domain.CarDomain;

public class Application {
    public static void main(String[] args) {
        InputController consoleController = new InputController();
        RaceController raceController = new RaceController();

        List<CarDomain> cars = consoleController.getCarNameRequest();
        int round = consoleController.getRoundRequest();
        
        // RaceController 코드 입력

        Console.close();
    }
}
