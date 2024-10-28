package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarController {
    private final Input input;
    private final Output output;


    public RacingCarController(Input input, Output output) {
        this.input = new Input();
        this.output = new Output();
    }

    public void startGame() {
        List<String> carNames = input.getCarName();
        int tryCount = input.getRound();
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        Cars cars = new Cars(carList);
        RacingGame game = new RacingGame(cars, tryCount);

        output.printExecutionResult();
        game.play(() -> output.printRoundResult(cars));
        output.printWinners(game.getWinners());
    }
}
