package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.Validator;

public class InputHandler {
    private final Validator validator = new Validator();

    public String[] getCarNames() {
        String inputString = Console.readLine();
        validator.validateInput(inputString);
        return getCarNamesArray(inputString);
    }

    private String[] getCarNamesArray(String inputString) {
        String[] carNames = inputString.split(",");
        validator.validateCarNames(carNames);
        return carNames;
    }

    public int getTryNum() {
        String tryNum = Console.readLine();
        validator.validateInput(tryNum);
        validator.validateTryNum(tryNum);
        return Integer.parseInt(tryNum);
    }
}
