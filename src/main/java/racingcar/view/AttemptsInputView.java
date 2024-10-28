package racingcar.view;

import static racingcar.message.InputRequestMessage.NUMBER_OF_ATTEMPTS_REQUEST_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class AttemptsInputView implements InputView, View {
    @Override
    public void printView() {
        printRequest();
        getInput();
    }

    @Override
    public void printRequest() {
        System.out.println(NUMBER_OF_ATTEMPTS_REQUEST_MESSAGE.getMessage());
    }

    @Override
    public String getInput() {
        return Console.readLine();
    }
}
