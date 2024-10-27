package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public static int inputNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int numberOfAttempts = Integer.parseInt(Console.readLine());
            validatePositiveNumber(numberOfAttempts);
            return numberOfAttempts;
        }catch (RuntimeException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
    }
    private static void validatePositiveNumber(int number) {
        if(number <= 0 )
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
    }
}
