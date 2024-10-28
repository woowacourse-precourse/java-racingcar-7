package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNamesValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public static List<String> getCarNames() {
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다. ,를 이용하여 두 개 이상의 자동차 이름을 입력해주세요.");
        }

        // 배열을 리스트로 변환하여 CarNamesValidator에 전달
        return CarNamesValidator.validate(Arrays.asList(input.split(DELIMITER)));
    }

    public static int getTryTime() {
        String input = Console.readLine();

        // 입력이 없을 때
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수를 입력하지 않았습니다.");
        }

        try {
            int result = Integer.parseInt(input);

            if (result < 1) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
    }
}
