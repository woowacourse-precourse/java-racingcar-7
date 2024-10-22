package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockGoingValueGenerator extends GoingValueGenerator {

    private final List<GoingValue> result;

    public MockGoingValueGenerator(GoingValue... result) {
        this.result = new ArrayList<>(Arrays.asList(result));
    }

    @Override
    public GoingValue generate() {
        if (result.isEmpty()) {
            return GoingValue.GO;
        }
        return result.removeFirst();
    }
}
