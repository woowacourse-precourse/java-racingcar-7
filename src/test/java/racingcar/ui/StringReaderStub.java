package racingcar.ui;

import racingcar.ui.StringReader;

public class StringReaderStub extends StringReader {
    private String testLine;

    public StringReaderStub() {}

    @Override
    public String readLine() {
        return testLine;
    }

    public void setMockUserInput(String value) {
        testLine = value;
    }
}
