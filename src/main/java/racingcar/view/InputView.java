package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InvalidCountException;

public class InputView {

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(",");
    }

    public static int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return validateStringToNumber(Console.readLine());
    }

    private static int validateStringToNumber(String input) {
        try{
            int count = Integer.parseInt(input);
            validatePositiveNumber(count);
            return count;
        } catch (NumberFormatException e) {
            throw new InvalidCountException("시도할 횟수는 숫자이어야 합니다.");
        }

    }

    private static void validatePositiveNumber(int count) {
        if (count <= 0) {
            throw new InvalidCountException("시도할 횟수는 양의 정수이어야 합니다.");
        }
    }
}
