package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private String carNamesWithComa;

    public void carNamesWithComa() {
        carNamesWithComa = Console.readLine();
    }

    public String getNamesWithComa() {
        return carNamesWithComa;
    }
}
