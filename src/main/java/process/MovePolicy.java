package process;

import camp.nextstep.edu.missionutils.Randoms;

public class MovePolicy {
    public boolean run() {
        int value = Randoms.pickNumberInRange(0, 9);
        return value > 4;
    }
}
