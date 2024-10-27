package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String text = Console.readLine().replaceAll("\\s", "");
        List<String> carNames = List.of(text.split(","));

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야합니다.");
            }

            if (carName.isBlank()) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        return carNames;
    }

    public static int getRunLimit() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            int runLimit = Integer.parseInt(input);
            if (runLimit < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }

            return runLimit;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
