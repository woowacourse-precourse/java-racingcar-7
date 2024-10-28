package racingcar.fake;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import racingcar.model.MovementFactorGenerator;

public class FakeMovementFactorGenerator implements MovementFactorGenerator {

    private final Queue<Integer> factors;

    public FakeMovementFactorGenerator(List<Integer> factors) {
        this.factors = new ArrayDeque<>(factors);
    }

    @Override
    public int generate() {
        if (factors.isEmpty()) {
            throw new IllegalStateException();
        }
        return factors.poll();
    }

}
