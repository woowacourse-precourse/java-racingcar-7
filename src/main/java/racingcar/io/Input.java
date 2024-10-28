package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String readLine() {
        return Console.readLine();
    }

    public static String readString() {
        String name = readLine();
        validateNullAndEmpty(name);
        return name;
    }

    public static int readToInteger() {
        String read = readLine();
        validateNullAndEmpty(read);
        try {
            return Integer.parseInt(read);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("정수만을 입력 할 수 있습니다.");
        }
    }

    private static void validateNullAndEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열을 입력할 수 없습니다.");
        }
    }

}
