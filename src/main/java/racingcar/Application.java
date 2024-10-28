package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        String input = Console.readLine();
        validateNames(input);

        System.out.print("시도할 횟수는 몇 회인가요?: ");
        String attemptsInput = Console.readLine();
        int attempts = validateAttempts(attemptsInput);

        System.out.println("입력된 이름들: " + input);
        System.out.println("시도할 횟수: " + attempts);

        int randNum = Randoms.pickNumberInRange(0, 9);


    }

    private static void validateNames(String input) {
        String[] names = input.split(",");
        if (names.length < 2) {
            throw new IllegalArgumentException("이름이 두 개 이상이어야 합니다.");
        }
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5자 이하여야 합니다: " + name);
            }
        }
    }

    private static int validateAttempts(String attemptsInput) {
        if (!isNumeric(attemptsInput) || Integer.parseInt(attemptsInput) <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 0보다 큰 숫자여야 합니다.");
        }
        return Integer.parseInt(attemptsInput);
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
