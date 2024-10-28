package racingcar.policy;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.function.Predicate;

public enum MovingPolicy {
    RANDOM(num -> num >= 4);

    private final Predicate<Integer> predicate;

    MovingPolicy(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }
    public static MovingPolicy getCurrentPolicy() {
        return RANDOM;
    }
    public boolean isMoveable() {
        return predicate.test(Randoms.pickNumberInRange(0,9));
    }
}
