package racingcar.view;

import static racingcar.util.ConstantVariable.FIRST_CAR_NAME_INPUT;
import static racingcar.util.ConstantVariable.MAX_TRY_COUNT;
import static racingcar.util.CustomStringUtils.printFinalWinners;
import static racingcar.util.CustomStringUtils.printStringLineFeed;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;
import racingcar.dto.request.RacingCarRequest;
import racingcar.dto.response.RacingCarWinnerResponse;
import racingcar.util.CustomValidator;
import racingcar.util.SingletonObjectProvider;

public class RacingCarView {

    private final RacingCarController racingCarController;

    public RacingCarView() {
        this.racingCarController = SingletonObjectProvider.getSingletonObject(RacingCarController.class);
    }

    public void startCalculateProgram() {
        printStringLineFeed(FIRST_CAR_NAME_INPUT.value());
        String carNames = Console.readLine();

        printStringLineFeed(MAX_TRY_COUNT.value());
        String tryCount = Console.readLine();

        if (!CustomValidator.validateNumber(tryCount)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }

        RacingCarWinnerResponse response =
                racingCarController.calculate(RacingCarRequest.of(carNames, Integer.parseInt(tryCount)));

        printFinalWinners(response.winners());
    }
}
