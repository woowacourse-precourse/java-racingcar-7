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
        List<Car> cars = Arrays.stream(carNames.split(NAME_SPLIT_DELIMITER))
                .map(Car::new)
                .toList();

        return new RacingCars(cars);
    }

    public AttemptCount getAttemptCountFromUser() {
        String attemptCount = Console.readLine();

        return new AttemptCount(parseAsInteger(attemptCount));
    }

    private int parseAsInteger(String attemptCount) {
        try {
            return Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ATTEMPT_COUNT_TYPE.getDescription());
        }
    }
}