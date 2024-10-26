package racingcar.app.server.model.car;

import camp.nextstep.edu.missionutils.Randoms;

public class SpeedGenerator {

    private SpeedGenerator() {
    }

    public static Speed generateRandomSpeed() {
        return Speed.from(Randoms.pickNumberInRange(0, 9));
    }
}
