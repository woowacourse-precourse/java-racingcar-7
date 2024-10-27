package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_ROUND_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String EMPTY_NAME_ERROR = "자동차 이름은 필수입니다.";
    private static final String INVALID_ROUND_INPUT = "경주 횟수는 1 이상의 정수여야 합니다.";

    public static List<String> inputCarNames() {
        System.out.println(CAR_NAME_PROMPT);
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(InputView::validateCarName)
                .collect(Collectors.toList());
    }

    public static int inputRounds() {
        System.out.println(RACE_ROUND_PROMPT);
        String input = Console.readLine();
        return validateRoundInput(input);
    }

    private static void validateCarName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private static int validateRoundInput(String input) {
        try {
            int rounds = Integer.parseInt(input);
            if (rounds <= 0) {
                throw new IllegalArgumentException(INVALID_ROUND_INPUT);
            }
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ROUND_INPUT, e);
        }
    }
}
