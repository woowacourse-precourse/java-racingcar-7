package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

public class InputView {

    private static final String DELIMITER = ",";

    public List<String> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        return Stream.of(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public int readAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
