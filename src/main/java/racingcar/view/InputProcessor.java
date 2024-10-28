package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Race;
import racingcar.view.validator.carName.CarNameValidatorFacade;
import racingcar.view.validator.racingNumber.RacingNumberValidatorFacade;

public class InputProcessor {

    private final CarNameValidatorFacade carNameValidatorFacade;
    private final RacingNumberValidatorFacade racingNumberValidatorFacade;
    private final InputView inputView;

    public InputProcessor(CarNameValidatorFacade carNameValidatorFacade, RacingNumberValidatorFacade racingNumberValidatorFacade) {
        this.carNameValidatorFacade = carNameValidatorFacade;
        this.racingNumberValidatorFacade = racingNumberValidatorFacade;
        this.inputView = InputView.getInstance();
    }

    public List<String> receiveCarNames() {
        System.out.println(Message.RECEIVE_CAR_NAMES);

        String input = inputView.getInput();
        List<String> carNames = parseCarNames(input);

        carNameValidatorFacade.validateAll(carNames);

        return carNames;
    }

    public Race receiveRacingNumber() {
        System.out.println(Message.RECEIVE_RACING_NUMBER);

        String input = inputView.getInput();
        racingNumberValidatorFacade.validateAll(input);

        long raceNumber = Long.parseLong(input);

        return Race.of(raceNumber);
    }

    private static List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(",", -1))
                .toList();
    }
}
