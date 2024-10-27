package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputHandlerEmb implements InputHandler {
    @Override
    public String getInput() {
        return Console.readLine();
    }
}
