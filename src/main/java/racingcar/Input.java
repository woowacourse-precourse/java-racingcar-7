package racingcar;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Input {

    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> inputCarNames() {
        System.out.println("자동차들: ");
        String input = scanner.nextLine();
        List<String> inputConverter = Stream.of(input.split(",")).map(String::trim).distinct().toList();
        validateNameCount(inputConverter);
        return inputConverter;
    }

    public int inputRound() {
        System.out.println("라운드: ");
        int rounds = scanner.nextInt();
        validateRoundCount(rounds);
        return rounds;
    }

    private void validateNameCount(List<String> inputConverter) {
        if (inputConverter.size() > 5) {
            throw new IllegalArgumentException("출전할 수 있는 차량은 최대 5대 입니다.");
        }
    }

    private void validateRoundCount(int rounds) {
        if (rounds > 10) {
            throw new IllegalArgumentException("최대 10라운드까지 진행 할 수 있습니다.");
        }
    }
}
