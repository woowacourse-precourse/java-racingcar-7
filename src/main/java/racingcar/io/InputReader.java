package racingcar.io;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    private static final String CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private final InputValidator validator = new InputValidator();
    private final InputParser parser = new InputParser();

    public List<String> readCarNames() {
        System.out.println(CARS_MESSAGE);
        String input = Console.readLine();

        validator.validateCarNames(input);

        return List.of(input.split(","));
    }

    public int readCount() {
        System.out.println(ROUND_MESSAGE);
        String input = Console.readLine().trim();

        int count = parser.parseInt(input);
        validator.validateCount(count);

        return count;
    }

}