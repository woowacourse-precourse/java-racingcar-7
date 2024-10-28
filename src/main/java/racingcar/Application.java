package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        try {
            RaceController raceController = new RaceController();
            raceController.start();
        } finally {
            Console.close();
        }
    }
}
