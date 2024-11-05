package racingcar.decider;

import camp.nextstep.edu.missionutils.Randoms;

public class FixedRatioDecider implements Decider{
    private final int numerator;
    private final int denominator;
    public FixedRatioDecider(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    @Override
    public boolean decideMoveOrNot() {
        int picked = Randoms.pickNumberInRange(0, denominator);
        return picked >= numerator;
    }
}
