package racingcar.record;

import java.util.HashMap;
import java.util.Map;

public class Record {
    private Map<String,Integer> latestPosition;
    private StringBuilder trace;
    public Record(){
        latestPosition = new HashMap<>();
        trace = new StringBuilder();
        trace.append("실행 결과").append("\n");
    }

    public Map<String, Integer> getLatestPosition() {
        return latestPosition;
    }

    public StringBuilder getTrace() {
        return trace;
    }
}
