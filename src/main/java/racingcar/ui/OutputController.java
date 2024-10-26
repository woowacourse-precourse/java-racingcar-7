package racingcar.ui;

public class OutputController {

    private final OutputConsole outputConsole;

    public OutputController(final OutputConsole outputConsole) {
        this.outputConsole = outputConsole;
    }

    public void printNameInputInformation() {
        this.outputConsole.printWithLineBreak("경주할 자동차 이름을 입력하세요.(이름은 쉼포(,) 기준으로 구분)");
    }
}