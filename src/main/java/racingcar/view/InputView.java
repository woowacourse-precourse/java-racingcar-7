package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNames() {
        System.out.println(Message.INPUT_CAR_NAME.message);
        return Console.readLine();
    }

    private enum Message {
        INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
