package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public Input getUserInput() {
        List<String> splitNames = getNames();
        int tryCount = getTryCount();

        Console.close();

        return new Input(splitNames, tryCount);
    }

    private List<String> getNames() {
        System.out.println(REQUEST_CAR_NAMES);
        String names = Console.readLine();
        return inputParser.parseNames(names);
    }

    private int getTryCount() {
        System.out.println(REQUEST_TRY_COUNT);
        String tryCount = Console.readLine();
        return inputParser.parseTryCount(tryCount);
    }


}
