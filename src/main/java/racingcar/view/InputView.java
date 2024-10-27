package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Race;
import racingcar.view.validator.carName.CarNameValidatorFacade;
import racingcar.view.validator.racingNumber.RacingNumberValidatorFacade;

public class InputView {

    private final CarNameValidatorFacade carNameValidatorFacade;
    private final RacingNumberValidatorFacade racingNumberValidatorFacade;

    public InputView() {
        this.carNameValidatorFacade = new CarNameValidatorFacade();
        this.racingNumberValidatorFacade = new RacingNumberValidatorFacade();
    }

    public List<String> receiveCarNames() {
        System.out.println(Message.RECEIVE_CAR_NAMES);

        String input = getInput();
        List<String> carNames = stringToList(input);

        carNameValidatorFacade.validateAll(carNames);

        return carNames;
    }

    public Race receiveRacingNumber() {
        System.out.println(Message.RECEIVE_RACING_NUMBER);

        String input = getInput();

        racingNumberValidatorFacade.validateAll(input);

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
