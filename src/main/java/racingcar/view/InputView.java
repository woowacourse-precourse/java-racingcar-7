package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<Car> getCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateDelimiter(input);
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getNumberOfAttempt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validateIsNumeric(input);
        return convertToInt(input);
    }


    private void validateDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("구분자는 쉼표로 작성해야 합니다.");
        }
    }

    private void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }
}
