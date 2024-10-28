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

        int repetitionCount = getRepetitionCount();

        playGame(repetitionCount, cars);
        announceWinners(cars);

        Input.close();
    }

    private void announceWinners(List<Car> cars) {
        String winners = winner.getWinners(cars);
        Output.winner(winners);
    }

    private void playGame(int repetitionCount, List<Car> cars) {
        Output.executionResult();
        for (int i = 0; i < repetitionCount; i++) {
            for (Car car : cars) {
                int range = carService.incrementMoveCount(car);
                Output.playerResult(car.getName(), range);
            }
            System.out.println();
        }
    }

    private int getRepetitionCount() {
        Output.howManyTry();
        return Input.inputRepetition();
    }
}
