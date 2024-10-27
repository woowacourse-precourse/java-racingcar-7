package racingcar.view.input;

public class TestReader implements Reader {

    private String inputText = "";

    @Override
    public String read() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}
