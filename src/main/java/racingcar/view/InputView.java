package racingcar.view;

import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";

    private final TryCountValidator tryCountValidator;

    public InputView(TryCountValidator tryCountValidator) {
        this.tryCountValidator = tryCountValidator;
    }

    public List<String> scanCarNames(){
        String carNameString = readLine();
        return Arrays.asList(carNameString.split(CAR_NAME_DELIMITER));
    }

    public int scanTryCount() {
        String stringTryCount = readLine();

        int tryCount = tryCountValidator.convertTryCountToInt(stringTryCount);
        tryCountValidator.validTryCount(tryCount);

        return tryCount;
    }
}
