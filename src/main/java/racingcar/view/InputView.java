package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCarsName() {
        String CarsName = Console.readLine();
        return CarsName;
    }

    public int getRoundNumber() {
        String RoundNumber = Console.readLine();
        return Integer.parseInt(RoundNumber);
    }
}
