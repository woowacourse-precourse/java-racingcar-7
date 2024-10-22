package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockOngoingValueGenerator extends OngoingValueGenerator {

    private final List<OngoingValue> result;

    public MockOngoingValueGenerator(OngoingValue... result) {
        this.result = new ArrayList<>(Arrays.asList(result));
    }

    @Override
    public OngoingValue generate() {
        if (result.isEmpty()) {
            return OngoingValue.GO;
        }
        return result.removeFirst();
    }
}
