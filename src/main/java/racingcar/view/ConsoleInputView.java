package racingcar.view;

import static racingcar.validate.Validator.getValidatedCarNames;
import static racingcar.validate.Validator.getValidatedRepeatCount;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class ConsoleInputView implements InputView{

    @Override
    public ArrayList<String> readCarNames() throws IllegalArgumentException {
        Message.INPUT_CAR_NAME.display();
        String carNames = Console.readLine();
        return getValidatedCarNames(carNames);
    }

    @Override
    public int readRepeatCount() throws IllegalArgumentException {
        Message.INPUT_REPEAT_COUNT.display();
        String repeatCount = Console.readLine();
        return getValidatedRepeatCount(repeatCount);
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
