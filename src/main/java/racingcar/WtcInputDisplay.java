package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class WtcInputDisplay implements IInputDisplay{

    @Override
    public String getPromptInput(String msg) {
        System.out.print(msg);

        String input = Console.readLine();
        Console.close();

        return input;
    }
}
