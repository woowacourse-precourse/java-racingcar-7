package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {
    private List<Car> cars;

    public Play(List<Car> cars) {
        this.cars = cars;
    }

    public void play(String tryCountString) {
        try {
            int tryCount = Integer.parseInt(tryCountString);

            for (int i = 0; i < tryCount; ++i) {
                moveCars();
            }

        } catch (NumberFormatException npe) {
            throw new IllegalArgumentException();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);

            if (randomValue >= 4) {
                car.move();
            }
        }
    }
}
