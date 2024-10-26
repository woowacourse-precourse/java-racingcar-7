package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class RacingGameService {
    public void play(List<Car> cars){
        for (Car car : cars) {
            randomMove(car);
        }
    }

    private void randomMove(Car car){
        car.move(Randoms.pickNumberInRange(0, 9) >= 4);
    }
}
