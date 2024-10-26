package racingcar.controller;

import racingcar.dto.RacingRequest;
import racingcar.dto.RacingResponse;
import racingcar.util.Parser;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class MainController {

    private final RacingController racingController = new RacingController();

    public void start(){
        UserOutputView.InputCarNameMessage();
        String carNames = UserInputView.readUserInput();

        UserOutputView.InputAttemptCountMessage();
        int attemptCount = Parser.parseStringToInt(UserInputView.readUserInput());

        RacingResponse response = racingController.startRace(new RacingRequest(carNames, attemptCount));
        UserOutputView.RacingRoundMessage(response.moveData());
        UserOutputView.RacingResultMessage(response.winner());
    }
}