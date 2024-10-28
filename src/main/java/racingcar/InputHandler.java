package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateCarNamesInput(input);

        List<String> carNames = new ArrayList<>();
        for (String carName : input.split(",")) {
            carName = carName.strip();
            validateCarName(carName);
            carNames.add(carName);
        }

        return carNames;
    }

    public static int getTotalRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return parseAndValidatePositiveInteger(input);
    }

    private static void validateCarNamesInput(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 입력하세요.");
        }
        if (input.split(",").length == 0) {
            throw new IllegalArgumentException("쉼표 사이에 이름이 작성되어야 합니다.");
        }
    }

    private static void validateCarName(final String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("쉼표 사이에 이름이 작성되어야 합니다.");
        }
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 포함될 수 없습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하로 작성 가능합니다.");
        }
    }

    private static int parseAndValidatePositiveInteger(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 자연수로 입력해주세요.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 자연수로 입력해주세요.");
        }
    }
}
