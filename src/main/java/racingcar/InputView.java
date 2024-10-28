package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(name -> new Car(name, new RandomMoveStrategy()))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;  // 예외를 다시 던져 프로그램을 종료
        }
    }

    public static int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            int attempts = Integer.parseInt(input);
            validateAttempts(attempts);  // 시도 횟수 유효성 검사
            return attempts;
        } catch (NumberFormatException e) {
            System.out.println("시도 횟수는 숫자여야 합니다.");
            throw new IllegalArgumentException("잘못된 시도 횟수 입력입니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static void validateAttempts(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
