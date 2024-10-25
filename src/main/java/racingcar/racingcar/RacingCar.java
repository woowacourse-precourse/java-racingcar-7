package racingcar.racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String name;
    private static final int YOU_CAN_GO_IF_MORE_THAN_THIS = 4;

    public RacingCar(String name) {
        this.name = name;
    }

    public int run() {
        int canGo = Randoms.pickNumberInRange(0, 9);
        if (canGo >= YOU_CAN_GO_IF_MORE_THAN_THIS) {
            return 1;
        }
        return 0;
    }

    public String getName() {
        return name;
    }
}
