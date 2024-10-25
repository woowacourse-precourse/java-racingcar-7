package racingcar.accelerator;

import camp.nextstep.edu.missionutils.Randoms;

public class BrokenAccelerator implements Accelerator {

    @Override
    public int accelerate(int threshold) {
        if (Randoms.pickNumberInRange(0, 9) >= threshold) {
            return 1;
        }
        return 0;
    }
}
