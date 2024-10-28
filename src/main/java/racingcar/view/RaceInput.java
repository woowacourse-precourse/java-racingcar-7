package racingcar.view;

import static racingcar.constant.ErrorMessage.NO_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class RaceInput {
    private static final String NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_TIME_PROMPT = "시도할 횟수는 몇 회인가요?";

    private RaceInput() {
    }

    public static String getNames() {
        RaceOutput.println(NAMES_PROMPT);
        return getLine();
    }

    public static String getRaceTime() {
        RaceOutput.println(RACE_TIME_PROMPT);
        return getLine();
    }

    private static String getLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(NO_INPUT.getMessage());
        }
    }
}
