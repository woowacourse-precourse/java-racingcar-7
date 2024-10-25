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
        RacingResponse racing = racingController.racing(new RacingRequest(carNames, attemptCount));
        UserOutputView.RacingRoundMessage(racing.race(), attemptCount);
        UserOutputView.RacingResultMessage(racing.winner());
    }
}
