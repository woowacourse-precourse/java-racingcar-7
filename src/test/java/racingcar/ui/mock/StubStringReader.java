package racingcar.ui.mock;

import racingcar.ui.StringReader;

public class StubStringReader extends StringReader {
    private String testLine;

    public StubStringReader() {}

    @Override
    public String readLine() {
        return testLine;
    }

    public void setMockUserInput(String value) {
        testLine = value;
    }
}
