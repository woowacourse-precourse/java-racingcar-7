package racingcar.car.infrastructure;

import static racingcar.global.util.CarConst.*;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.service.port.RandomHolder;

public class CarRandomHolder implements RandomHolder {
    @Override
    public int getRandom() {
        return Randoms.pickNumberInRange(RANDOM_START_RANGE, RANDOM_END_RANGE);
    }
}
