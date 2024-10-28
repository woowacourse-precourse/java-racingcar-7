package racingcar;

import static racingcar.prompt.CarRacingEnrollPrompt.ATTEMPT_KEY;
import static racingcar.prompt.CarRacingEnrollPrompt.CAR_NAMES_KEY;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.accelerator.BrokenAccelerator;
import racingcar.prompt.PromptModel;

public class CarRacingEnroll {

    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final String CAR_NAME_LENGTH_EXCEPTION_MSG = "자동차 이름은 한 글자 이상, 5자 이하여야 합니다.";
    public static final String ATTEMPT_RANGE_EXCEPTION_MSG = "유효한 숫자 범위를 벗어났습니다.";

    private boolean validateCarName(String carName) {
        return carName != null && !carName.isEmpty() && carName.length() <= CAR_NAME_MAX_LENGTH;
    }

    public Car createCar(String carName) {
        if (!validateCarName(carName)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MSG);
        }
        return new Car(carName, new BrokenAccelerator());
    }


    public CarGroup createCarGroup(String input) {
        return new CarGroup(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(this::createCar)
                .collect(Collectors.toList()));
    }

    public int extractAttempt(String input) {
        int attempt = 0;
        try {
            attempt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_RANGE_EXCEPTION_MSG);
        }

        if (attempt < 0) {
            throw new IllegalArgumentException(ATTEMPT_RANGE_EXCEPTION_MSG);
        }
        return attempt;
    }

    public CarRacing lineUp(PromptModel promptModel) {
        CarGroup carGroup = createCarGroup(promptModel.get(CAR_NAMES_KEY));
        int attempt = extractAttempt(promptModel.get(ATTEMPT_KEY));

        return new CarRacing(carGroup, attempt);
    }
}
