package racingcar.view;

import static racingcar.message.InputRequestMessage.NAMES_REQUEST_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void printCarNamesRequestMessage() {
        System.out.println(NAMES_REQUEST_MESSAGE.getMessage());
    }

    public String getCarNames() {
        return Console.readLine();
    }
}
