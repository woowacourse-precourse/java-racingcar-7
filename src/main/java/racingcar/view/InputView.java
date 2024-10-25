package racingcar.view;

import static racingcar.message.InputRequestMessage.NAMES_REQUEST;
import static racingcar.message.InputRequestMessage.NUMBER_OF_ATTEMPT_REQUEST;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void printCarNamesRequest() {
        System.out.println(NAMES_REQUEST.getMessage());
    }

    public String getCarNames() {
        return Console.readLine();
    }

    public void printNumberOfAttemptRequest() {
        System.out.println(NUMBER_OF_ATTEMPT_REQUEST.getMessage());
    }
}
