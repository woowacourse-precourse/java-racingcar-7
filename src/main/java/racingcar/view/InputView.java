package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.exception.CarNameException;
import racingcar.exception.MoveCountException;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");
    private static final String COMMA_DELIMITER = ",";

    private static final String CAR_NAME_EMPTY_ERROR = "자동차 이름을 입력해주세요.";
    private static final String CAR_NAME_DELIMITER_ERROR = "자동차 이름은 쉼표(,)를 기준으로 구분하여야합니다.";
    private static final String CAR_NAME_LENGTH_ERROR = "각 자동차 이름은 1자 이상 5자 이하로 입력해주어야합니다.";
    private static final String ATTEMPTS_EMPTY_ERROR = "이동횟수를 입력해주세요.";
    private static final String ATTEMPTS_ZERO_ERROR = "이동횟수는 1번 이상이어야합니다.";
    private static final String ATTEMPTS_NEGATIVE_ERROR = "이동횟수는 음수가 될 수 없습니다.";
    private static final String ATTEMPTS_NUMBER_ERROR = "이동횟수는 숫자로만 입력가능합니다.";
    
    public InputView() {
    }

    public static List<String> getCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String inputCarNames = Console.readLine();
        validateCarNames(inputCarNames);
        return List.of(inputCarNames.split(COMMA_DELIMITER));
    }

    public static int getNumberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS_MESSAGE);
        String inputNumber = Console.readLine();
        validateNumberOfAttempts(inputNumber);
        return Integer.parseInt(inputNumber);
    }

    private static void validateCarNames(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new CarNameException(CAR_NAME_EMPTY_ERROR);
        }

        if (!carNames.contains(COMMA_DELIMITER)) {
            throw new CarNameException(CAR_NAME_DELIMITER_ERROR);
        }

        String[] names = carNames.split(COMMA_DELIMITER);
        for (String name : names) {
            checkNameLength(name.trim());
        }
    }

    private static void checkNameLength(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new CarNameException(CAR_NAME_LENGTH_ERROR);
        }
    }

    private static void validateNumberOfAttempts(String inputNum) {
        if (inputNum == null || inputNum.isBlank()) {
            throw new MoveCountException(ATTEMPTS_EMPTY_ERROR);
        }
        if (inputNum.equals("0")) {
            throw new MoveCountException(ATTEMPTS_ZERO_ERROR);
        }
        if (inputNum.contains("-")) {
            throw new MoveCountException(ATTEMPTS_NEGATIVE_ERROR);
        }
        if (!NUMBER_PATTERN.matcher(inputNum).matches()) {
            throw new MoveCountException(ATTEMPTS_NUMBER_ERROR);
        }
    }
}
