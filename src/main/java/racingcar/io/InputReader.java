package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputReader {

    private final InputValidator validator = new InputValidator();
    private final InputParser parser = new InputParser();

    public List<String> readCarNames() {
        String input = Console.readLine();
        validator.validateInput(input);

        List<String> cars = parser.parseCarNames(input);
        validator.validateName(cars);

        return cars;
    }

    public int readCount() {
        String input = Console.readLine().trim();
        validator.validateInput(input);

        int count = parser.parseInt(input);
        validator.validateCount(count);

        return count;
    }

}