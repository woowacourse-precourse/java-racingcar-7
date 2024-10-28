package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String readLine() {
        return Console.readLine();
    }

    public static String readNames() {
        Output.printNameGuide();
        String name = readLine();
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차는 하나 이상 등록해야 합니다.");
        }
        return name;
    }

}
