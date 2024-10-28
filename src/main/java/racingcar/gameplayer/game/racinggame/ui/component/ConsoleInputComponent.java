package racingcar.gameplayer.game.racinggame.ui.component;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputComponent implements InputComponent{

    @Override
    public String getValue(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
