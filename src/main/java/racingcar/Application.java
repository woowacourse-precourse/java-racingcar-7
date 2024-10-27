package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;

public class Application {

    public static void main(String[] args) {
        new RacingController().run();
        Console.close();
    }

}
