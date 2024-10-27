package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Race;
import racingcar.view.validator.CarNameDuplicateValidator;
import racingcar.view.validator.CarNameLengthValidator;
import racingcar.view.validator.CarNameNullValidator;
import racingcar.view.validator.CarNameNumberValidator;
import racingcar.view.validator.CarNameValidator;
import racingcar.view.validator.RacingNumberFormatValidator;
import racingcar.view.validator.RacingNumberNullValidator;
import racingcar.view.validator.RacingNumberValidator;

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

    public Race receiveRacingNumber() {
        System.out.println(Message.RECEIVE_RACING_NUMBER);

        String input = getInput();

        RacingNumberValidator racingNumberNullValidator = new RacingNumberNullValidator();
        RacingNumberValidator racingNumberFormatValidator = new RacingNumberFormatValidator();

        racingNumberNullValidator.validate(input);
        racingNumberFormatValidator.validate(input);

        long raceNumber = Long.parseLong(input);

        return Race.of(raceNumber);
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static List<String> stringToList(String input) {
        return Arrays.stream(input.split(",", -1))
                .toList();
    }
}
