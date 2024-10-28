package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.Model.Car;

public class RacingGameService {

    public void runRound(List<Car> cars) {
        for (Car car : cars) {
            moveCarIfPossible(car);
        }
    }

    private void moveCarIfPossible(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        car.move(randomNumber);
    }
}
