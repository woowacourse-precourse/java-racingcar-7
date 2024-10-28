package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator.CarNameValidator;
import racingcar.Validator.CarNamesValidator;
import racingcar.Validator.InputValidator;
import racingcar.Validator.NumberValidator;

public class Input {
    private static final InputValidator inputValidator;

    static {
        CarNamesValidator carNamesValidator = new CarNamesValidator();
        CarNameValidator carNameValidator = new CarNameValidator();
        NumberValidator numberValidator = new NumberValidator();

        inputValidator = new InputValidator(carNamesValidator, carNameValidator, numberValidator);
    }

    public static String getCarNames(){
        String carNames = Console.readLine();
        inputValidator.validateCarNames(carNames);
        inputValidator.validateCarName(carNames);
        return carNames;
    }

    public static int getNumber(){
        String inputNumber = Console.readLine();
        inputValidator.validateNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }
}
