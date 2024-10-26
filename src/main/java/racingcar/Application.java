package racingcar;

import racingcar.controller.RacingController;
import racingcar.strategy.ModeType;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.PrintMessage;

public class Application {
    public static void main(String[] args) {
        OutputView.printMessageWithLine(PrintMessage.INPUT_CAR_NAME_MESSAGE);
        RacingController racingController = new RacingController(InputView.inputUser());

        racingController.setCarMode(ModeType.RACING_CAR);

        OutputView.printMessageWithLine(PrintMessage.INPUT_TRY_CAR_MOVEMENT_MESSAGE);
        racingController.setTotalRacingRound(InputView.inputUser());

        OutputView.printMessageWithLine(PrintMessage.LINE_SPACE);
        OutputView.printMessageWithLine(PrintMessage.CAR_RACE_RESULT_MESSAGE);
        racingController.startRacing();

        OutputView.printMessage(PrintMessage.CAR_RACE_WINNER_MESSAGE);
        OutputView.printCarRacingResult(racingController.endRacing());
    }
}
