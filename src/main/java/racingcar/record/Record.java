package racingcar.record;

import java.util.HashMap;
import java.util.Map;

public class Record {
    private final Map<String, Integer> latestPosition;
    private final StringBuilder trace;

    public Record() {
        latestPosition = new HashMap<>();
        trace = new StringBuilder();
    }

    public Map<String, Integer> getLatestPosition() {
        return latestPosition;
    }

    public StringBuilder getTrace() {
        return trace;
    }
}
