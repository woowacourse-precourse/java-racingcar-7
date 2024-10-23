package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> participants = divideMember(getInput());
    }

    public static String getInput() {
        return Console.readLine();
    }

    public static List<String> divideMember(String input) {
        return List.of(input.split(","));
    }
}
