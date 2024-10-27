package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarService;
import racingcar.domain.winner.Winner;
import racingcar.io.input.Input;
import racingcar.io.output.Output;
import racingcar.util.RandomUtil;

public class Game {

    private final CarService carService;
    private final Winner winner;

    public Game() {
        this.carService = new CarService(new RandomUtil());
        this.winner = new Winner();
    }

    public void run() {
        Output.playGameInit();
        List<String> carNames = Input.inputCarNames();
        List<Car> cars = carService.getCars(carNames);

        Output.howManyTry();
        int repetitionCount = Input.inputRepetition();

        Output.executionResult();
        for (int i = 0; i < repetitionCount; i++) {
            for (Car car : cars) {
                carService.incrementMoveCount(car);
            }
            System.out.println();
        }

        String winners = winner.getWinners(cars);
        Output.winner(winners);

        Input.close();
    }
}
