package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    public void run() {
        List<Car> cars = initializeCars();
        RacingGame game = new RacingGame(cars);
        int moves = InputView.getNumberOfMoves();

        for (int i = 0; i < moves; i++) {
            game.race();
            OutputView.printRaceResult(game.getCars());
        }

        List<Car> winners = findWinners(game.getCars(), game.getMaxPosition());
        OutputView.printWinners(winners);
    }

    private List<Car> initializeCars() {
        String[] carNames = InputView.getCarNames().split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty() || trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
            }
            cars.add(new Car(trimmedName));
        }

        return cars;
    }

    private List<Car> findWinners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
