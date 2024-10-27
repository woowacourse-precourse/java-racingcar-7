package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.request.RacingCarRequest;
import racingcar.util.StringValidator;

import static racingcar.util.ConstantVariables.FIRST_CAR_NAME_INPUT;
import static racingcar.util.ConstantVariables.MAX_TRY_COUNT;
import static racingcar.util.CustomStringUtils.printStringLineFeed;

public abstract class InputView {
    public static RacingCarRequest input() {
        printStringLineFeed(FIRST_CAR_NAME_INPUT.value());
        String carNames = Console.readLine();

        printStringLineFeed(MAX_TRY_COUNT.value());
        String tryCount = Console.readLine();

        if (!StringValidator.validateNumber(tryCount)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }

        return RacingCarRequest.of(carNames, Integer.parseInt(tryCount));
    }
}