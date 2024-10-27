package View;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNames = Console.readLine().trim();

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        List<String> carNameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        for (String name : carNameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }

        return carNameList;
    }

    public static int inputAttemptNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            String input = Console.readLine().trim();
            if (input.isEmpty()) {
                throw new IllegalArgumentException("시도할 횟수가 빈 값일 수 없습니다.");
            }

            int attemptNumber = Integer.parseInt(input);
            if (attemptNumber <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 1 이상의 숫자이어야 합니다.");
            }
            return attemptNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다.");
        }
    }
}
