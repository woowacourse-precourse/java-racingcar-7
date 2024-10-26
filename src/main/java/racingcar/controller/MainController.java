package racingcar.controller;

import racingcar.dto.CreateCarsRequest;
import racingcar.dto.GetWinnersResponse;
import racingcar.dto.StartRaceRequest;
import racingcar.dto.StartRaceResponse;
import racingcar.util.Parser;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class MainController {

    private final RacingController racingController = new RacingController();

    public void start() {
        UserOutputView.InputCarNameMessage();
        String carNames = UserInputView.readUserInput();
        racingController.createCars(new CreateCarsRequest(carNames));

        UserOutputView.InputAttemptCountMessage();
        int attemptCount = Parser.parseStringToInt(UserInputView.readUserInput());

        StartRaceResponse startRaceresponse = racingController.startRace(new StartRaceRequest(attemptCount));
        UserOutputView.RacingRoundMessage(startRaceresponse.roundMoveData());

        GetWinnersResponse getWinnersResponse = racingController.getWinners();
        UserOutputView.RacingResultMessage(getWinnersResponse.winnersName());
    }
}