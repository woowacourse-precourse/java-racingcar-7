package racingcar.presentation;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.model.value.Name;

import java.util.Arrays;
import java.util.List;

public class InputReader {

    private static final String INVALID_COUNT = "1 이상의 숫자를 입력해야합니다.";

    public static List<Name> readCarNames() {
        String userInput = Console.readLine();
        String[] carNames = userInput.split(",");

        return Arrays.stream(carNames)
                .map(Name::new)
                .toList();
    }

    public static Long readCount() {
        try {
            return readCountValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT);
        }
    }

    private static long readCountValue() {
        String userInput = Console.readLine();

        long count = Long.parseLong(userInput);
        if (count < 1) {
            throw new NumberFormatException();
        }
        return count;
    }
}
