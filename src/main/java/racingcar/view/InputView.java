package racingcar.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String DELIMITER = ",";
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String EMPTY_ERROR = "[빈 값] 자동차 이름은 빈 값일 수 없습니다.";
    private static final String NAME_LENGTH_ERROR = "[길이 제한] 자동차 이름 길이는 %d를 넘을 수 없습니다.";
    private static final String TYPE_CASTING_ERROR = "[타입 변환] 숫자만 입력 가능합니다.";
    private static final String NUMBER_SIGN_ERROR = "[부호] 양수만 입력 가능합니다.";

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        return parseCarNames(input);
    }

    public int readMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readLine();
        return parseMoveCount(input);
    }

    public List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(DELIMITER));
        validateCarNames(carNames);
        return carNames;
    }

    public int parseMoveCount(String input) {
        validateMoveCount(input);
        return Integer.parseInt(input);
    }

    private void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateEmpty(name);
            validateNameLength(name);
        }
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_ERROR, NAME_LENGTH_LIMIT));
        }
    }

    private void validateMoveCount (String input) {
        validateNumber(input);
        validatePositiveNumber(input);
    }

    private void validateNumber(String input) {
        try {
            int n = Integer.parseInt(input);
        } catch (Exception e){
            throw new IllegalArgumentException(TYPE_CASTING_ERROR);
        }
    }

    private void validatePositiveNumber(String input) {
        int number = Integer.parseInt(input);
        if(number <= 0) {
            throw new IllegalArgumentException(NUMBER_SIGN_ERROR);
        }
    }
}
