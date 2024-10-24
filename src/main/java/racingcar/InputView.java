package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void printNameMessage() {
        System.out.println(GameMessages.INPUT_GUIDE_NAME_MESSAGE);
    }

    public void printNumberMessage() {
        System.out.println(GameMessages.INPUT_GUIDE_NUMBER_MESSAGE);
    }

    public String input() {
        return Console.readLine();
    }
}
