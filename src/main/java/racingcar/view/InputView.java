package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.GameSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final int MAX_NAME_LENGTH = 5;

    public static GameSettings getGameSettings() {
        System.out.println("자동차 이름을 입력하세요(이름은 쉼표(,)로 구분) : ");
        String carNameInput = Console.readLine();
        List<String> carName = parseCarName(carNameInput);

        System.out.println("시도할 횟수를 입력하세요 : ");
        String attemptCountInput = Console.readLine();
        int attemptCount = parseAttemptCount(attemptCountInput);

        return new GameSettings(carName, attemptCount);
    }
    private static List<String> parseCarName(String input) {
        List<String> carName = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        for (String name : carName) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
            }
        }
        return carName;
    }
    private static int parseAttemptCount(String input) {
        try {
            int attemptCount = Integer.parseInt(input);
            if (attemptCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
        }
    }
}
