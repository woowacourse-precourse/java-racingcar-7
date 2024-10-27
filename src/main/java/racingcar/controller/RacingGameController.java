package racingcar.controller;

import racingcar.converter.GameOverDTOConverter;
import racingcar.dto.GameOverDTO;
import racingcar.dto.GameStartDTO;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.service.CarService;
import racingcar.service.InputProcessService;
import racingcar.service.RacingGameService;
import racingcar.view.GameOverView;
import racingcar.view.GameStartView;

import java.util.List;

public class RacingGameController {
    private final GameStartView gameStartView;
    private final GameOverView gameOverView;
    private final InputProcessService inputProcessService;
    private final CarService carService;
    private final RacingGameService racingGameService;
    private final GameOverDTOConverter gameOverDTOConverter;

    public RacingGameController(GameStartView gameStartView,
                                GameOverView gameOverView,
                                InputProcessService inputProcessService,
                                CarService carService,
                                GameOverDTOConverter gameOverDTOConverter){
        this.gameStartView = gameStartView;
        this.gameOverView = gameOverView;
        this.inputProcessService = inputProcessService;
        this.carService = carService;
        this.racingGameService = new RacingGameService(carService);
        this.gameOverDTOConverter = gameOverDTOConverter;
    }

    public void startGame(){
        GameStartDTO userInput = gameStartView.gameStart();

        inputProcessService.inputValidation(userInput);
        List<String> carsInput = inputProcessService.processCarsInput(userInput.getCarsInput());
        Integer roundInput = inputProcessService.processRoundInput(userInput.getRoundInput());

        List<Car> cars = carService.registerCars(carsInput);

        RacingGame game = racingGameService.registerRacingGame(roundInput, cars);

        game = racingGameService.racingGameProgress(game);

        game = racingGameService.findWinners(game);

        GameOverDTO gameResult = gameOverDTOConverter.toGameOverDTO(game);

        gameOverView.gameOver(gameResult);
    }
}
