package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("이름을 입력해주세요: ");
        String names = Console.readLine();
        int tryCount = inputRaceAttempts();

    }

    // 시도할 횟수 입력받기
    public static int inputRaceAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return validateAttempts(input);
    }

    // 입력받은 숫자가 유효한 숫자인지 검사
    private static int validateAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

}