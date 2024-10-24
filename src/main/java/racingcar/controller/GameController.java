package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try{
            List<Car> cars = createCars();
            int attempts = inputView.readAttempts();

            RacingGame game = new RacingGame(cars, attempts);
            game.play();

            outputView.printWinners(game.getWinners());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            throw e;
        }
    }

    private List<Car> createCars(){
        List<String> names = inputView.readCarNames();
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
