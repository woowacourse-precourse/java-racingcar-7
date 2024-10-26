package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputReader {

    private final InputParser inputParser;

    public InputReader(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public List<String> getNames() {
        final String input = Console.readLine();
        return inputParser.toList(input);
    }

    public int getTryCount() {
        final String number = Console.readLine();
        return inputParser.toPositive(number);
    }

}
