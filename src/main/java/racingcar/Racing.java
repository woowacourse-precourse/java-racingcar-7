package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {

    public int makeRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void playRacing(List<Car> cars) {
        for (Car car : cars) {
            car.move(makeRandomValue());
        }
    }
}
