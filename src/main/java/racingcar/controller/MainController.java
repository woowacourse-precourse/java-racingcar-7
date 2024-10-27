package racingcar.controller;

import racingcar.dto.CreateCarsRequest;
import racingcar.dto.GetWinnersResponse;
import racingcar.dto.StartRaceRequest;
import racingcar.dto.StartRaceResponse;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.RaceService;
import racingcar.util.Parser;
import racingcar.view.UserInputView;
import racingcar.view.UserOutputView;

public class MainController {

    private final CarRepository carRepository = new CarRepository();
    private final RaceController raceController = new RaceController(new RaceService(carRepository));
    private final CarController carController = new CarController(new CarService(carRepository));

    public void start() {
        UserOutputView.InputCarNameMessage();
        String carNames = UserInputView.readUserInput();
        carController.createCars(new CreateCarsRequest(carNames));

        UserOutputView.InputAttemptCountMessage();
        int attemptCount = Parser.parseStringToInt(UserInputView.readUserInput());

        StartRaceResponse startRaceresponse = raceController.startRace(new StartRaceRequest(attemptCount));
        UserOutputView.RaceRoundResultMessage(startRaceresponse.roundMoveData());

        GetWinnersResponse getWinnersResponse = raceController.getWinners();
        UserOutputView.RaceWinnersMessage(getWinnersResponse.winnersName());
    }
}