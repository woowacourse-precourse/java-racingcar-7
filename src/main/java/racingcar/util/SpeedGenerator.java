package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.car.Speed;

public class SpeedGenerator {
    public static Speed generateRandomSpeed() {
        return Speed.from(Randoms.pickNumberInRange(0, 9));
    }
}
