package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarController {

    public String readLine() {
        String str = Console.readLine();
        Console.close();
        return str;
    }
}
