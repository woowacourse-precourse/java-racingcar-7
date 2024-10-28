package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final InputValidator inputValidator;

    static {
        CarNameValidator carNameValidator = new CarNameValidator();
        NumberValidator numberValidator = new NumberValidator();

        inputValidator = new InputValidator(carNameValidator, numberValidator);
    }

    public static String getCarNames(){
        String carNames = Console.readLine();
        inputValidator.validateCarNames(carNames);
        inputValidator.validateCarName(carNames);
        return carNames;
    }

    public static int getNumber(){
        int number = Integer.parseInt(Console.readLine());
        inputValidator.validateNumber(number);
        return number;
    }
}
