package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Message;
import racingcar.model.InputModel;

public class InputView {

    public void printInputCarNameMessage() {
        System.out.println(Message.INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputTryCountMessage() {
        System.out.println(Message.INPUT_TRY_COUNT_MESSAGE);
    }

    public String getInput() {
        String input = Console.readLine();
        InputModel inputModel = new InputModel(input);
        return inputModel.getInput();
    }
}
