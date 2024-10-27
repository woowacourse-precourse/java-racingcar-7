package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.repository.GameSequenceRepository;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.service.Validator;
import racingcar.view.InputVIew;
import racingcar.view.OutputView;

public class MainController {
    private static final CarService carService = new CarService();
    private static final GameService gameService = new GameService();
    private static final CarRepository carRepository = new CarRepository();
    private static final Validator validator = new Validator();

    public void run() {
        String input = InputVIew.getRacerName();
        validator.checkEmpty(input);
        int attemptTime = InputVIew.getAttemptTime();

        carService.makeCar(input);

        play(createGame(attemptTime), attemptTime);
    }

    private Game createGame(int attemptTime) {
        List<Car> carList = carRepository.findAll();
        Game game = new Game(carList, attemptTime);
        gameService.save(game);
        return game;
    }

    private void play(Game game, int attemptTime) {
        OutputView.printResultHead();
        for(int i=0; i<attemptTime; i++) {
            gameService.play(game);
            OutputView.printScore(game.getCars());
        }
        OutputView.printWinners(gameService.getWinners(game));
    }
}
