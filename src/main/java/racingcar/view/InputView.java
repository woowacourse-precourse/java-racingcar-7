package racingcar.view;

import static racingcar.util.Delimiter.COMMA;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import racingcar.exception.NonNumericException;

public class InputView {

    private final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)";
    private final String INVALID_INPUT = "잘못된 입력입니다.";
    private final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String readCarNames() {
        System.out.println(String.format(INPUT_CAR_NAME_MESSAGE, COMMA.getDelimiter()));
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    public int readTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        int inputCount;

        try {
            inputCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new NonNumericException();
        }

        return inputCount;
    }
}
