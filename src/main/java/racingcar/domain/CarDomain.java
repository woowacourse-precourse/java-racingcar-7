package racingcar.domain;

import static racingcar.common.constant.Constant.DEFAULT_MOVE_DISTANCE;
import static racingcar.common.constant.Constant.INCLUSIVE_RANGE;
import static racingcar.common.constant.Constant.MOVE_FORWARD_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public class CarDomain {
    private final String name;
    private Integer distance;

    private CarDomain(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public static CarDomain create(String name, Integer distance) {
        return new CarDomain(name, distance);
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void attemptMove() {
        if (isMove()) {
            this.distance += DEFAULT_MOVE_DISTANCE;
        }
    }

    private boolean isMove() {
        int randomNumber = Randoms.pickNumberInRange(INCLUSIVE_RANGE.min(), INCLUSIVE_RANGE.max());
        return MOVE_FORWARD_RANGE.contains(randomNumber);
    }
}
