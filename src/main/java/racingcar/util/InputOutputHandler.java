package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputOutputHandler {

    private final InputParser inputParser;

    public InputOutputHandler() {
        this.inputParser = new InputParser();
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return inputParser.parseCars(input);
    }

    public int getRound() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String input = Console.readLine();
        return inputParser.parseRound(input);
    }
}
