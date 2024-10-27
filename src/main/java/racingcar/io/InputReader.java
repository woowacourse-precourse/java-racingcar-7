package racingcar.io;

import java.util.List;
import java.util.Scanner;

public class InputReader {

    private static final String CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String INVALID_NUMBER_ERROR = "유효한 숫자를 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator validator = new InputValidator();

    public List<String> readCarNames() {
        System.out.println(CARS_MESSAGE);
        String input = scanner.nextLine();

        validator.validateCarNames(input);

        return List.of(input.split(","));
    }

    public int readCount() {
        System.out.println(ROUND_MESSAGE);
        String input = scanner.nextLine().trim();

        int count = parse(input);
        validator.validateCount(count);

        return count;
    }

    private int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR);
        }
    }

}