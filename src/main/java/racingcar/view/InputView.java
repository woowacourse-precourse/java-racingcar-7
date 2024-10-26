package racingcar.view;

import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

import java.util.Arrays;
import java.util.List;

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

    public List<String> scanCarNames(){
        String carNameString = readLine();

        List<String> carNames = Arrays.asList(carNameString.split(CAR_NAME_DELIMITER));

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
