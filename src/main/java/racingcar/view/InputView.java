package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.view.validator.CarNameDuplicateValidator;
import racingcar.view.validator.CarNameLengthValidator;
import racingcar.view.validator.CarNameNullValidator;
import racingcar.view.validator.CarNameNumberValidator;
import racingcar.view.validator.CarNameValidator;

public class InputView {

    public List<String> receiveCarNames() {
        System.out.println(Message.RECEIVE_CAR_NAMES);

        String input = getInput();
        List<String> carNames = stringToList(input);

        CarNameValidator carNameNumberValidator = new CarNameNumberValidator();
        CarNameValidator carNameNullValidator = new CarNameNullValidator();
        CarNameValidator carNameLengthValidator = new CarNameLengthValidator();
        CarNameValidator carNameDuplicateValidator = new CarNameDuplicateValidator();
        carNameNumberValidator.validate(carNames);
        carNameNullValidator.validate(carNames);
        carNameLengthValidator.validate(carNames);
        carNameDuplicateValidator.validate(carNames);

        return carNames;
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static List<String> stringToList(String input) {
        return Arrays.stream(input.split(",", -1))
                .toList();
    }
}
