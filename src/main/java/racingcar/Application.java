package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static String inputString() {
        return inputString(null);
    }

    private static String inputString(String message) {
        if (message == null) {
            return Console.readLine();
        }
        System.out.println(message);
        return Console.readLine();
    }
}
