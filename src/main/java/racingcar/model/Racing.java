package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {

    public void advance(Cars cars) {
        for (Car car : cars.getCars()) {
            if (isMovable()) {
                car.addAdvanceMarker();
            }
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }
}
