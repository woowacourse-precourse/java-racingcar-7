package racingcar.view;

import racingcar.dto.response.RacingCarResponse;

import static racingcar.util.CustomStringUtils.printFinalWinners;

public abstract class OutputView {
    public static void printOutput(RacingCarResponse result) {
        printFinalWinners(result.winners());
    }
}