package racingcar.view;

import static racingcar.message.InputRequestMessage.NAMES_REQUEST_MESSAGE;
import static racingcar.message.InputRequestMessage.NUMBER_OF_ATTEMPTS_REQUEST_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void printCarNamesRequest() {
        System.out.println(NAMES_REQUEST_MESSAGE.getMessage());
    }

    public String getCarNames() {
        return Console.readLine();
    }

    public void printNumberOfAttemptsRequest() {
        System.out.println(NUMBER_OF_ATTEMPTS_REQUEST_MESSAGE.getMessage());
    }

    public String getNumberOfAttempts() {
        return Console.readLine();
    }
}
