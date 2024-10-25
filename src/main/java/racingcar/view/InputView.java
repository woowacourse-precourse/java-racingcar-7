package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputName() {
        try {
            return Console.readLine();
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    public int inputRound() {
        try {
            String sentence = Console.readLine();
            return Integer.parseInt(sentence);
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
