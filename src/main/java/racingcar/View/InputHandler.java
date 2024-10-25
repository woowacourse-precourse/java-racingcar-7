package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SimpleTimeZone;

public class InputHandler {
    private static final String ALPHA_NUMERIC_PATTERN = "[a-zA-Z0-9]+";
    private static final int CAR_MAX_LENGTH = 5;
    private static final int MOVE_ATTEMPT_COUNT_MAX = 100;
    private static final int MOVE_ATTEMPT_COUNT_MIN = 1;
    List<String> carNames;
    int moveAttemptCount = 0;

    public InputHandler() {
        carNames = new ArrayList<>();
    }

    public List<String> carNames() {
        String userInput = Console.readLine();
        List<String> splitCarNames = Arrays.asList(userInput.split(","));
        validateCarNames(splitCarNames);
        carNames.addAll(splitCarNames);
        return carNames;
    }

    private void validateCarNames(List<String> splitCarNames) {
        checkAlphaNumericName(splitCarNames);
        checkCarNameLength(splitCarNames);
        checkCarCount(splitCarNames);
        checkDuplicateName(splitCarNames);
    }

    private void checkCarCount(List<String> splitCarNames) {
        if (splitCarNames.size() > 100 || splitCarNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 개수는 0~100개 입니다.");
        }
    }

    private void checkCarNameLength(List<String> splitCarNames) {
        for (String carName : splitCarNames) {
            if (carName.length() > CAR_MAX_LENGTH || carName.isEmpty()) {
                throw new IllegalArgumentException("자동차의 이름의 길이는 1~5글자입니다.");
            }
        }
    }

    private void checkAlphaNumericName(List<String> splitCarNames) {
        for (String carName : splitCarNames) {
            if (!carName.isEmpty() && !carName.matches(ALPHA_NUMERIC_PATTERN)) {
                throw new IllegalArgumentException("자동차의 이름은 영어 대소문자, 숫자로만 가능합니다.: " + carName);
            }
        }
    }

    private void checkDuplicateName(List<String> splitCarNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : splitCarNames) {
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름은 허용하지 않습니다.");
            };
        }
    }

    public int moveAttemptCount() {
        String userInput = Console.readLine();
        parseToInt(userInput);
        validateAttemptCount(moveAttemptCount);
        return moveAttemptCount;
    }

    private void validateAttemptCount(int moveAttemptCount) {
        checkCountRange(moveAttemptCount);
    }

    private void parseToInt(String userInput) {
        try {
            moveAttemptCount = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 숫자여야 합니다.");
        }
    }

    private void checkCountRange(int moveAttemptCount) {
        if (moveAttemptCount < MOVE_ATTEMPT_COUNT_MIN || moveAttemptCount > MOVE_ATTEMPT_COUNT_MAX) {
            throw new IllegalArgumentException("이동시도횟수 범위는 1~100 입니다.");
        }
    }
}
