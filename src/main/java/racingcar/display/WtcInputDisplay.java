package racingcar.display;

import camp.nextstep.edu.missionutils.Console;

public class WtcInputDisplay implements IInputDisplay {

    @Override
    public String getPromptInput(String msg) {
        System.out.print(msg);

        return Console.readLine();
    }
}
