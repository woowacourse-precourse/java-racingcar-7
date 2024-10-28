package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputAttemptHandler {
    public int getAttemptCount(){
        System.out.print("시도할 횟수를 입력하세요. : ");
        String count = Console.readLine();
        return validateAttemptCount(count);
    }

    private int validateAttemptCount(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("정수로만 입력해 주세요.");
        }
        int count = Integer.parseInt(input);
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수로 입력해야 합니다.");
        }
        return count;
    }
}
