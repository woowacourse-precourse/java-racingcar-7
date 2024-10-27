package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;

public class MockGameLogic extends GameLogic {

    private final Map<String, StringBuilder> result;

    public MockGameLogic() {
        this.result = new LinkedHashMap<>();
    }

    @Override
    public Map<String, StringBuilder> getResult() {
        return result;
    }

    @Override
    public void moveCarsIfQualified() {
        result.put("test1", new StringBuilder("----"));
        result.put("test2", new StringBuilder("--"));
        result.put("test3", new StringBuilder("----"));
    }
}
