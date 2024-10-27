package racingcar.model;

public class InputVal {
    private String inputString;
    private int inputCount;

    private InputVal(String inputString, int inputCount) {
        this.inputString = inputString;
        this.inputCount = inputCount;
    }

    public static InputVal create(String inputString, int inputCount) {
        return new InputVal(inputString, inputCount);
    }

    public String getInputString() {
        return inputString;
    }

    public int getInputCount() {
        return inputCount;
    }
}
