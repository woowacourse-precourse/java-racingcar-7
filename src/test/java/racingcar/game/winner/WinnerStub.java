package racingcar.game.winner;

import java.util.List;

public class WinnerStub extends Winner {
    private List<String> testValue;

    public WinnerStub() {
        super(null);
    }

    protected WinnerStub(List<String> names) {
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
