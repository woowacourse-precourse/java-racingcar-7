package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public Input getUserInput(OutputView outputView) {
        outputView.printNameRequest();
        String[] splitNames = getNames();

        outputView.printTryCountRequest();
        int tryCount = getTryCount();
        Console.close();

        return new Input(splitNames, tryCount);
    }

    private String[] getNames() {
        String names = Console.readLine();
        return inputParser.parseNames(names);
    }

    private int getTryCount() {
        String tryCount = Console.readLine();
        return inputParser.parseTryCount(tryCount);
    }


}
