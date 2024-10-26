package racingcar.view;

import static racingcar.Util.Utils.splitNamesByComma;
import static racingcar.validate.Validator.validateCarNames;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class InputView {

    public ArrayList<String> readCarNames() throws IllegalArgumentException {
        System.out.println(Message.INPUT_CAR_NAME.message);
        String input = Console.readLine();
        validateCarNames(input);
        return splitNamesByComma(input);
    }

    private enum Message {
        INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
