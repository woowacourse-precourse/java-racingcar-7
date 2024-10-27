package racingcar.car;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.MyException.INVALID_CAR_NAME;
import static racingcar.Util.genLongerThanX;

import java.util.function.Function;

public class RandomCar extends Car {
    public RandomCar(String name) {
        super(name);
    }

    @Override
    public void move() {
        if (pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    @Override
    protected void checkName(String name) {
        Function<String, Boolean> longerThanLimit = genLongerThanX(5);
        if (name == null || name.isBlank() || longerThanLimit.apply(name)) {
            throw INVALID_CAR_NAME.getException();
        }
    }
}
