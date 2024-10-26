package racingcar.rule;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomAboveFourRule implements RaceRule {

    @Override
    public boolean isMovePermitted() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }
}
