package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.service.RaceService;
import racingcar.validator.AttemptCountValidator;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    InputView inputView = new InputView();
    GameService gameService = new GameService();
    RaceService raceService = new RaceService();
    AttemptCountValidator attemptCountValidator = new AttemptCountValidator();
    OutputView outputView = new OutputView();

    public void run(){
        final String carNamesString = inputView.promptCarNames();
        List<Car> cars = gameService.createCarsList(carNamesString);

        final String attemptCountString = inputView.promptAttemptCount();
        attemptCountValidator.validate(attemptCountString);
        final int attemptCount = Integer.parseInt(attemptCountString);

        startGame(attemptCount, cars);
        List<String> winnerNames = gameService.getWinners(cars);
        outputView.displayFinalResults(winnerNames);
    }


    public void startGame(int attemptCount, List<Car> cars){
        System.out.println("\n"+"실행 결과");
        for(int i = 0; i < attemptCount; i++){
            raceService.runRound(cars);
            outputView.displayRoundresults(cars);
        }
    }
}
