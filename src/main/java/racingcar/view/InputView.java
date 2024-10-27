package racingcar.view;

import static racingcar.Util.Utils.splitNamesByComma;
import static racingcar.validate.Validator.validateCarNames;
import static racingcar.validate.Validator.validateRepeatCount;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class InputView {

    public static ArrayList<String> readCarNames() throws IllegalArgumentException {
        Message.INPUT_CAR_NAME.display();
        String carNames = Console.readLine();
        validateCarNames(carNames);
        return splitNamesByComma(carNames);
    }

    public static int readRepeatCount() {
        Message.INPUT_REPEAT_COUNT.display();
        String repeatCount = Console.readLine();
        validateRepeatCount(repeatCount);
        return Integer.parseInt(repeatCount);
    }

    private enum Message {
        INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_REPEAT_COUNT("시도할 횟수는 몇 회인가요?");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        private void display() {
            System.out.print(message + System.lineSeparator());
        }
    }
}
