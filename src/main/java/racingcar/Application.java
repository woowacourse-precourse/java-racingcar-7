package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.controller.RaceController;

public class Application {
    public static void main(String[] args) {
        new RaceController().start();
        Console.close();
    }
}
