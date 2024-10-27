package racingcar.ui.reader;

import racingcar.ui.UserInputRequester;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class InputReader {
    private final UserInputRequester userInput;

    private final int  MAX_NAME_LENGTH = 5;
    private final String NAME_DELIMITER = ",";
    private final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String MOVEMENT_ATTEMPT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public InputReader(UserInputRequester userInputRequester) {
        userInput = userInputRequester;
    }

    public List<String> readNames() {
        List<String> result = splitNames(userInput.request(CAR_NAME_PROMPT));
        if(hasInvalidName(result))
            throw new IllegalArgumentException("이름 최대 길이를 초과함");
        return result;
    }

    public int readMovementAttempts() {
        try {
            return Integer.parseInt(userInput.request(MOVEMENT_ATTEMPT_PROMPT));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력");
        }
    }

    private List<String> splitNames(String line) {
        return Arrays.stream(line.split(NAME_DELIMITER)).toList();
    }

    private boolean hasInvalidName(List<String> names) {
        return toStringLength(names)
                .anyMatch(nameLength -> nameLength > MAX_NAME_LENGTH);
    }

    private IntStream toStringLength(List<String> names) {
        return names.stream().mapToInt(String::length);
    }
}
