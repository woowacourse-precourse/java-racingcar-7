package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceManager;

public class Application {
    public static void main(String[] args) {
        new RaceManager().execute();
        Console.close();
    }
}
