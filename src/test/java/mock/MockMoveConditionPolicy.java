package mock;

import static util.Utils.MOVING_FORWARD;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import racingcar.model.policy.MoveConditionPolicy;

public class MockMoveConditionPolicy implements MoveConditionPolicy {

    private final Deque<Integer> values;

    public MockMoveConditionPolicy(int... values) {
        this.values = new LinkedList<>();
        Arrays.stream(values).forEach(this.values::add);
    }

    @Override
    public int pickNumber() {
        int number = values.pop();
        this.values.add(number);
        return number;
    }

    @Override
    public boolean isMovable() {
        return pickNumber() >= MOVING_FORWARD;
    }
}
