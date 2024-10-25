package racingcar.view;

import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String SCAN_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String SCAN_TRY_OUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private final TryCountValidator tryCountValidator;
    private final CarNameValidator carNameValidator;

    public InputView(TryCountValidator tryCountValidator,
                     CarNameValidator carNameValidator) {
        this.tryCountValidator = tryCountValidator;
        this.carNameValidator = carNameValidator;
    }

    public String[] scanCarNames(){
        System.out.println(SCAN_CARS_MESSAGE);
        String carNameString = readLine();

        String[] carNames = carNameString.split(CAR_NAME_DELIMITER);

        carNameValidator.isLengthUnderFive(carNames);
        carNameValidator.isNotEmpty(carNames);

        return carNames;
    }

    public int scanTryCount() {
        System.out.println(SCAN_TRY_OUT_COUNT_MESSAGE);
        String stringTryCount = readLine();

        int tryCount = tryCountValidator.convertTryCountToInt(stringTryCount);
        tryCountValidator.validTryCount(tryCount);

        return tryCount;
    }
}
