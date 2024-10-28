package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.StringParser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static List<String> readCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = Console.readLine();
        List<String> carNames = StringParser.splitByComma(input);

        if (carNames.size() < 2) {
            throw new IllegalArgumentException();
        }

        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException();
        }

        return carNames;
    }

    public static int readAttemptNumber() {
        try {
            System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
            int attemptNumber = Integer.parseInt(Console.readLine());

            if (attemptNumber <= 0) {
                throw new IllegalArgumentException();
            }

            return attemptNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
