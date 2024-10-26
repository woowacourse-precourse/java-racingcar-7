package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.race.Speed;

public class SpeedGenerator {
    public static Speed generateRandomSpeed() {
        return Speed.from(Randoms.pickNumberInRange(0, 9));
    }
}
