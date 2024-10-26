package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.function.Predicate;

public enum Condition {
    RANDOM(num -> num >= 4);

    private final Predicate<Integer> predicate;

    Condition(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }

    public static Condition getCondition() {
        return RANDOM;
    }

    public boolean canMove() {
        return predicate.test(Randoms.pickNumberInRange(0, 9));
    }
}

