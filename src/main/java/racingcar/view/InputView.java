package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.ConstantMessage;

public class InputView {
    public String inputName() {
        System.out.println(ConstantMessage.INPUT_NAME_MESSAGE);
        try {
            return Console.readLine();
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    public int inputRound() {
        System.out.println(ConstantMessage.INPUT_ROUND_MESSAGE);
        try {
            String sentence = Console.readLine();
            return Integer.parseInt(sentence);
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
