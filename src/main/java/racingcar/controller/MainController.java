package racingcar.controller;

import racingcar.dto.CreateCarsRequest;
import racingcar.dto.GetWinnersResponse;
import racingcar.dto.StartRaceRequest;
import racingcar.dto.StartRaceResponse;
import racingcar.repository.CarRepository;
import racingcar.service.RaceService;
import racingcar.util.Parser;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class MainController {

    private final RaceController raceController = new RaceController(new RaceService(new CarRepository()));

    public void start() {
        UserOutputView.InputCarNameMessage();
        String carNames = UserInputView.readUserInput();
        raceController.createCars(new CreateCarsRequest(carNames));

        UserOutputView.InputAttemptCountMessage();
        int attemptCount = Parser.parseStringToInt(UserInputView.readUserInput());

        StartRaceResponse startRaceresponse = raceController.startRace(new StartRaceRequest(attemptCount));
        UserOutputView.RacingRoundMessage(startRaceresponse.roundMoveData());

        GetWinnersResponse getWinnersResponse = raceController.getWinners();
        UserOutputView.RacingResultMessage(getWinnersResponse.winnersName());
    }
}