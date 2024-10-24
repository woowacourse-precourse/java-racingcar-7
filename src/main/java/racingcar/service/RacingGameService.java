package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.entity.Car;
import racingcar.enums.RacingGameCondition;
import racingcar.view.OutputView;

public class RacingGameService {
    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void startGame(List<Car> cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            playRound(cars);
            OutputView.printRoundResults(cars);
        }
    }

    private void playRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= RacingGameCondition.MOVE_THRESHOLD.getValue()) {
                car.move();
            }
        }
    }
}
