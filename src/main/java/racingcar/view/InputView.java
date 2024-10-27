package racingcar.view;

import racingcar.view.console.ConsoleReader;
import racingcar.view.console.ConsoleWriter;
import racingcar.view.global.Validator;

public class InputView {
    private static final String REQUEST_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String requestCarsName() {
        ConsoleWriter.printlnMessage(REQUEST_CARS_MESSAGE);
        String input = ConsoleReader.enterMessage();
        Validator.validString(input);
        return input;
    }

}