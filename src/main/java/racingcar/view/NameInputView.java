package racingcar.view;

import static racingcar.message.InputRequestMessage.NAMES_REQUEST_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class NameInputView implements View, InputView {
    @Override
    public void printView() {
        printRequest();
        getInput();
    }

    @Override
    public void printRequest() {
        System.out.println(NAMES_REQUEST_MESSAGE.getMessage());
    }

    @Override
    public String getInput() {
        return Console.readLine();
    }
}
