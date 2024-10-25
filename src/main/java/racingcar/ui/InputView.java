package racingcar.ui;

import java.util.List;
import racingcar.utills.InputDevice;

public class InputView {
    private static final String CAR_NAMES_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";

    public static List<String> readCarNames() {
        System.out.println(CAR_NAMES_INPUT_PROMPT);
        return InputDevice.readStringListByDelimiter(DELIMITER);
    }

    public static int readTryCount() {
        System.out.println(TRY_COUNT_INPUT_PROMPT);
        return InputDevice.readInt();
    }
}
