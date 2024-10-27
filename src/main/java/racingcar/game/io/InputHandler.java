package racingcar.game.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.game.error.ErrorMessage;
import racingcar.game.model.AttemptCount;
import racingcar.game.model.Car;
import racingcar.game.model.RacingCars;

public class InputHandler {
    private static final String NAME_SPLIT_DELIMITER = ",";

    public RacingCars getCarsFromUser() {
        String carNames = Console.readLine();
        checkInputIsEmptyOrBlank(carNames);
        List<Car> cars = convertToCars(carNames);

        return new RacingCars(cars);
    }

    public AttemptCount getAttemptCountFromUser() {
        String attemptCount = Console.readLine();
        checkInputIsEmptyOrBlank(attemptCount);

        return new AttemptCount(parseAsInteger(attemptCount));
    }

    private void checkInputIsEmptyOrBlank(String input) {
        if (isInputBlankOrEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getDescription());
        }
    }

    private List<Car> convertToCars(String carNames) {
        return Arrays.stream(carNames.split(NAME_SPLIT_DELIMITER))
                .map(Car::new)
                .toList();
    }

    private int parseAsInteger(String attemptCount) {
        try {
            return Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ATTEMPT_COUNT_TYPE.getDescription());
        }
    }

    private boolean isInputBlankOrEmpty(String input) {
        return input.isEmpty() || input.isBlank();
    }
}