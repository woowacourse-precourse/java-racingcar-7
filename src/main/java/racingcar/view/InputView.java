package racingcar.view;

import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final TryCountValidator tryCountValidator;
    private final CarNameValidator carNameValidator;

    public InputView(TryCountValidator tryCountValidator,
                     CarNameValidator carNameValidator) {
        this.tryCountValidator = tryCountValidator;
        this.carNameValidator = carNameValidator;
    }

    public String[] scanCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = readLine();

        String[] carNames = carNameString.split(",");

        carNameValidator.isLengthUnderFive(carNames);
        carNameValidator.isNotEmpty(carNames);

        return carNames;
    }

    public int scanTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String stringTryCount = readLine();

        int tryCount = tryCountValidator.convertTryCountToInt(stringTryCount);
        tryCountValidator.validTryCount(tryCount);

        return tryCount;
    }
}
