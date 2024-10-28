package racingcar.service;

import racingcar.domain.Car;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class RacingGameService implements RacingGame {
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MOVABLE_NUMBER = 4;

    private final OutputView outputView;

    public RacingGameService(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public void raceGame(List<Car> cars, int count) {
        for (int i = 0; i < count; i++) {
            playRound(cars);
            outputView.displayCarPositions(cars);
        }
    }

    @Override
    public void playRound(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            if (randomValue >= MOVABLE_NUMBER) {
                car.move();
            }
        }
    }

    @Override
    public List<String> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
