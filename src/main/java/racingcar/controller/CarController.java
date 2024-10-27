package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.generator.Generator;
import racingcar.util.movement.MoveStrategy;
import racingcar.util.parser.InputSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private final MoveStrategy moveStrategy;
    private final InputSplitter inputSplitter;
    private final Generator<Integer> generator;
    private final InputView inputView;
    private final OutputView outputView;

    public CarController(MoveStrategy moveStrategy, InputSplitter inputSplitter,
                         Generator<Integer> generator) {
        this.moveStrategy = moveStrategy;
        this.inputSplitter = inputSplitter;
        this.generator = generator;
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    public void play() {
        String carNamesInput = inputView.getCarNames();

        int count = Integer.parseInt(inputView.getCount());

        Cars cars = new Cars();

        String[] carNames = inputSplitter.getCarNmaes(carNamesInput);
        for (String carName : carNames) {
            cars.addCar(new Car(carName.trim()));
        }

        for (int i = 0; i < count; i++) {
            for (Car car : cars.getCars()) {
                int number = generator.generate();
                car.move(moveStrategy.canMove(number));
            }
            outputView.showRoundResult(cars);
        }

        List<Car> winners = cars.getWinners();
        outputView.showWinners(winners);
    }
}
