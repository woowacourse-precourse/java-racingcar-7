package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {
    private static final int MOVE_STANDARD = 4;
    private static final int startInclusive = 0;
    private static final int endInclusive = 9;

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    public void moveCar(Car car) {
        int randomVal = Randoms.pickNumberInRange(startInclusive, endInclusive);
        if (MOVE_STANDARD <= randomVal) {
            car.move();
        }
    }
}
