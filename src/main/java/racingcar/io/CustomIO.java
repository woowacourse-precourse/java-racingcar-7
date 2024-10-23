package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class CustomIO {
    public String[] inputCarNames() {
        String s = Console.readLine();
        return s.split(",");
    }

    public int inputRepeatNum() {
        return Integer.parseInt(Console.readLine());
    }
}
