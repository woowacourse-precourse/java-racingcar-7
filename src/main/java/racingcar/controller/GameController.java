package racingcar.controller;

import racingcar.model.car.CarRepository;
import racingcar.model.raceGame.GameEngine;
import racingcar.util.StringProcessor;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
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
        String[] carNames = getCarNames();

        int trialCount = getTrialCount();

        carRepository.initCarRepository(carNames);

        runGame(trialCount);

        printWinners();
    }

    private String[] getCarNames(){
        String userCarInput = InputView.userInputCar();
        String[] carNameArr = StringProcessor.process(userCarInput);
        carValidator.validate(carNameArr);

        return carNameArr;
    }

    private int getTrialCount(){
        String userTrialInput = InputView.userInputTrial();
        trialValidator.validate(userTrialInput);
        return Integer.parseInt(userTrialInput);
    }

    private void runGame(int trial){
        for(int i = 0; i<trial; i++){
            gameEngine.runSingleRound();
            OutputView.printCarProgress(carRepository.getCarList());
        }
    }

    private void printWinners(){
        gameEngine.decideWinners();

        List<String> winners = gameEngine.getWinners();
        String winnerString = StringProcessor.formatWinner(winners);

        OutputView.printWinner(winnerString);
    }
}
