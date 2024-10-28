package racingcar.car;

public class ConditionChecker {
    private static final int MOVING_CRITERION = 4;


    public static boolean canMove(int criterion) {
        return criterion >= MOVING_CRITERION;
    }
}
