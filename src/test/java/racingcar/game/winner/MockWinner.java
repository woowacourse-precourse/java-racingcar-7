package racingcar.game.winner;

import java.util.List;

public class MockWinner extends Winner {
    private List<String> testValue;

    public MockWinner() {
        super(null);
    }

    protected MockWinner(List<String> names) {
        super(null);
    }

    public void setTestValue(List<String> testValue) {
        this.testValue = testValue;
    }

    @Override
    public List<String> getNames() {
        return testValue;
    }
}
