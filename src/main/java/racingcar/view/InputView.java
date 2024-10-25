package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final int MAX_TRY_COUNT = 100000000;

    public List<String> getInputCars(){
        String input = Console.readLine();
        return validateCarNames(input);
    }

    public int getInputCount() {
        String input = Console.readLine();
        validateWhitespace(input);
        validateNumberFormat(input);

        int tryCount = parseTryCount(input);
        validateTryCount(tryCount);

        return tryCount;
    }

    private void validateWhitespace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("횟수에 공백이 포함되었습니다.");
        }
    }

    private void validateNumberFormat(String input) {
        try {
            Float.parseFloat(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수가 숫자 형식이 아닙니다.");
        }
    }

    private int parseTryCount(String input) {
        float floatTryCount = Float.parseFloat(input);
        int intTryCount = (int) floatTryCount;

        if (intTryCount != floatTryCount) {
            throw new IllegalArgumentException("입력된 횟수가 실수입니다.");
        }

        return intTryCount;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("입력된 횟수가 0 이하 입니다.");
        }

        if (tryCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException("입력된 횟수가 비현실적으로 큽니다.");
        }
    }

    public static List<String> validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비어 있을 수 없습니다.");
        }

        List<String> carNames = Arrays.stream(input.split(",")).toList();
        if(carNames.size() <= 1) {
            throw new IllegalArgumentException("자동차 이름을 두 개 이상 입력해야 합니다.");
        }

        return carNames;
    }
}
