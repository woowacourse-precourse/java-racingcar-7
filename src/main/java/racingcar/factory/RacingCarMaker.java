package racingcar.factory;

import racingcar.race.RacingCar;

public class RacingCarMaker {

    private static final int NAME_MAXIMUM_LENGTH = 5;

    public RacingCar make(String name) {
        if (isInvalid(name)) {
            throw new IllegalArgumentException("경주 자동차 이름은 5자를 초과할 수 없습니다.");
        }
        return new RacingCar(name);
    }

    private boolean isInvalid(String name) {
        return name.length() > NAME_MAXIMUM_LENGTH;
    }

}
