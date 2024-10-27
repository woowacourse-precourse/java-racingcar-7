package view;

import static constant.Comment.CAR_NAME_INPUT_MESSAGE;
import static constant.Comment.COUNT_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getInputCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String getRounds() {
        System.out.println(COUNT_INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }
}
