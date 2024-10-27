package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class IOUtils {
    public static String input() {
        return Console.readLine();
    }

    public static void outputStringWithEnter(String message) {
        System.out.println(message);
    }

    public static void outputStringWithoutEnter(String message) {
        System.out.print(message);
    }
}
