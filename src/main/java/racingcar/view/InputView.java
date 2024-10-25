package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String input() {
        try{
            return Console.readLine();
        } catch(Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
