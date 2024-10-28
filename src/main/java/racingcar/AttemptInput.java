package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class AttemptInput {

    public int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readLine();

        int attempts = parseAttempts(input);
        validateAttempts(attempts);

        return attempts;
    }

    private int parseAttempts(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력하세요.");
        }
    }

    private void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }
}
