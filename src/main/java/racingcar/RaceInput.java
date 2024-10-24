package racingcar;

import static racingcar.ErrorMessage.EOF;
import static racingcar.ErrorMessage.WRONG_TRY_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class RaceInput {
    private static final String NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

    private RaceInput() {
    }

    public static String getNames() {
        System.out.println(NAMES_PROMPT);
        return getLine();
    }

    public static int getTryCount() {
        System.out.println(TRY_COUNT_PROMPT);
        String line = getLine();

        // TODO: Refactoring
        try {
            int tryCount = Integer.parseInt(line);
            if (tryCount < 0) {
                throw new IllegalArgumentException(WRONG_TRY_COUNT.getMessage());
            }

            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_TRY_COUNT.getMessage());
        }
    }

    private static String getLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(EOF.getMessage());
        }
    }
}
