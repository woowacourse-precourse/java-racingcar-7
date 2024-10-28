package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {
    private static final int MOVE_STANDARD = 4;
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    public void moveCar(Car car) {
        int randomVal = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (MOVE_STANDARD <= randomVal) {
            car.move();
        }
    }
}
