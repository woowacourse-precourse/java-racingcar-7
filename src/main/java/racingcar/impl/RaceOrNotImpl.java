package racingcar.impl;

import racingcar.model.RaceOrNot;
import camp.nextstep.edu.missionutils.Randoms;
public class RaceOrNotImpl implements RaceOrNot {
    @Override
    public boolean goForward() {
        int num = Randoms.pickNumberInRange(0, 9);
        return num > 3;
    }
}
