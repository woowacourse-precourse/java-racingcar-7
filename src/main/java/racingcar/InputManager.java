package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public static String readUserInput() {
        OutputManager.printGuideMessage();
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }
}
