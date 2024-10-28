package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomEngine implements Engine {

    @Override
    public boolean accelerate() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }
}
