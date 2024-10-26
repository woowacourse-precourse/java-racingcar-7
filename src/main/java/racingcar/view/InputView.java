package racingcar.view;

import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";

    private final TryCountValidator tryCountValidator;
    private final CarNameValidator carNameValidator;

    public InputView(TryCountValidator tryCountValidator,
                     CarNameValidator carNameValidator) {
        this.tryCountValidator = tryCountValidator;
        this.carNameValidator = carNameValidator;
    }

    public String[] scanCarNames(){
        String carNameString = readLine();

        String[] carNames = carNameString.split(CAR_NAME_DELIMITER);

        carNameValidator.isLengthUnderFive(carNames);
        carNameValidator.isNotEmpty(carNames);

        return carNames;
    }

    public int scanTryCount() {
        String stringTryCount = readLine();

        int tryCount = tryCountValidator.convertTryCountToInt(stringTryCount);
        tryCountValidator.validTryCount(tryCount);

        return tryCount;
    }
}
