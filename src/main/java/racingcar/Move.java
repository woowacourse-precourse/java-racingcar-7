package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Move {
    private static final int START_NUM = 0;
    private static final int END_NUM = 9;
    private static final int MOVE_CONDITION = 4;

    public static boolean isBoolean() {
        return MOVE_CONDITION <= Randoms.pickNumberInRange(START_NUM, END_NUM);
    }
}
