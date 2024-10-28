package racingcar.presentation;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.value.Name;

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

    public static int readCount() {
        try {
            return readCountValue();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT);
        }
    }

    private static int readCountValue() {
        String userInput = Console.readLine();

        int count = Integer.parseInt(userInput);
        if (count < 1) {
            throw new NumberFormatException();
        }
        return count;
    }
}
