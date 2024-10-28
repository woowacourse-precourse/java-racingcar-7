package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String NUMBER = "^[0-9]*$";
    private static final String NOT_NUMBER_MESSAGE = "플레이 횟수는 숫자를 입력해야 합니다";

    public static int playCount() {
        String playCount = Console.readLine();
        validatePlayCount(playCount);
        return Integer.parseInt(playCount);
    }

    private static void validatePlayCount(final String playCount) {
        if (!playCount.matches(NUMBER)) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    public static List<String> playerNames() {
        return stringToList(Console.readLine());
    }

    private static List<String> stringToList(final String names) {
        return Arrays.stream(names.split(","))
                .map(String::trim)
                .toList();
    }
}
