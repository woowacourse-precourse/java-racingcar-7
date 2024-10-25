package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNamesValidator;

public class InputView {
    private static final String DELIMITER = ",";

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다. ,를 이용하여 두 개 이상의 자동차 이름을 입력해주세요.");
        }

        return CarNamesValidator.validate(input.split(DELIMITER));
    }

    public static int getTryTime() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        // 아무것도 입력하지 않았을 때도 처리해줘야 함.
        try {
            int result = Integer.parseInt(Console.readLine());

            if (result < 1) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }

    }

}
