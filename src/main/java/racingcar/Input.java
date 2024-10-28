package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private String carNamesWithComa;
    private String tryCountString;

    public void carNamesWithComa() {
        carNamesWithComa = Console.readLine();
    }

    public void tryCount() {
        tryCountString = Console.readLine();
    }

    public String getNamesWithComa() {
        return carNamesWithComa;
    }

    public String getTryCount() {
        return tryCountString;
    }
}
