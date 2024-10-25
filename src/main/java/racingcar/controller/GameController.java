package racingcar.controller;

import racingcar.model.car.CarRepository;
import racingcar.model.raceGame.GameEngine;
import racingcar.util.StringProcessor;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final Validator<String[]> carValidator;
    private final Validator<String> trialValidator;
    private final CarRepository carRepository;
    private final GameEngine gameEngine;
    public GameController(Validator<String[]> carValidator, Validator<String> trialValidator, CarRepository carRepository){
        this.carValidator = carValidator;
        this.trialValidator = trialValidator;
        this.carRepository = carRepository;
        this.gameEngine = new GameEngine(carRepository);
    }
    public void run(){

        String userCarInput = InputView.userInputCar();
        String[] carNameArr = StringProcessor.process(userCarInput);

        carValidator.validate(carNameArr);

        String userTrialInput = InputView.userInputTrial();
        trialValidator.validate(userTrialInput);

        int trial = Integer.parseInt(userTrialInput);

        carRepository.initCarRepository(carNameArr);

        for(int i = 0; i<trial; i++){
            gameEngine.runSingleRound();
            OutputView.printCarProgress(carRepository.getCarList());
        }

        gameEngine.decideWinners();

        List<String> winners = gameEngine.getWinners();
        String winnerString = StringProcessor.formatWinner(winners);

        OutputView.printWinner(winnerString);
    }
}
