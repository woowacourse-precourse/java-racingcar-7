package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.Validation;

public class InputView {

    Validation validation = new Validation();

    public String getCarsName() {
        String CarsName = Console.readLine();
        validation.isNullOrEmpty(CarsName);
        return CarsName;
    }

    public int getRoundNumber() {
        String RoundNumber = Console.readLine();
        validation.isNullOrEmpty(RoundNumber);
        return Integer.parseInt(RoundNumber);
    }
}
