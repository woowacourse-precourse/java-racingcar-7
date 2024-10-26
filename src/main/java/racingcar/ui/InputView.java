package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public Input getUserInput() {
        String[] splitNames = getNames();

        int tryCount = getTryCount();
        Console.close();

        return new Input(splitNames, tryCount);
    }

    private String[] getNames() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String names = Console.readLine();
        return inputParser.parseNames(names);
    }

    private int getTryCount() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String tryCount = Console.readLine();
        return inputParser.parseTryCount(tryCount);
    }


}
