package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static final String INVALID_RACE_COUNT_MESSAGE = "시도 횟수는 1 이상이어야 합니다.";
    private static final String NAME_SEPARATOR = ","; // 구분자

    public List<String> getCarNames() {
        System.out.println(CAR_NAMES_PROMPT);
        String inputNames = Console.readLine();
        return Arrays.asList(inputNames.split(NAME_SEPARATOR));
    }

    public int getRaceCount() {
        System.out.println(RACE_COUNT_PROMPT);
        return validateRaceCount(Console.readLine());
    }

    public int validateRaceCount(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_RACE_COUNT_MESSAGE);
        }
        try {
            int raceCount = Integer.parseInt(input);

            if (raceCount <= 0) {
                throw new IllegalArgumentException(INVALID_RACE_COUNT_MESSAGE);
            }

            return raceCount;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_RACE_COUNT_MESSAGE);
        }
    }
}

