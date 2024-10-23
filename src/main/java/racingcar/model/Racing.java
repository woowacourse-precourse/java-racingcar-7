package racingcar.model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Supplier;

public class Racing {
    private final List<RacingCar> racingCarList;
    private final int round;

    public Racing(List<RacingCar> racingCarList, int round) {
        this.racingCarList = racingCarList;
        this.round = round;
    }

}
