package racingcar.view;

import racingcar.constants.OutputConstants;

public class OutputView {

    public void printCarRacingResult(String carName, String advanceResult) {
        System.out.println(String.format(OutputConstants.OUTPUT_CAR_RACING_RESULT_FORMAT, carName, advanceResult));
    }

    public void printCarRacingWinner(String carRacingWinners) {
        System.out.println(String.format(OutputConstants.OUTPUT_FINAL_WINNER, carRacingWinners));
    }

    public void printLineSpace() {
        System.out.println();
    }
}
