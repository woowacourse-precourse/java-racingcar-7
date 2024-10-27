package racingcar.view.output;

public class TestWriter implements Writer {

    private String outputText = "";

    @Override
    public void writeLine(String message) {
        this.outputText += message + "\n";
    }

    public String getOutputText() {
        return outputText;
    }
}
