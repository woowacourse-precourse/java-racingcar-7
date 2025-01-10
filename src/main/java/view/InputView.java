package view;

import camp.nextstep.edu.missionutils.Console;
import exception.CustomIllegalArgException;

public class InputView {

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().trim();
    }

    public int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요? (최대 10억까지 가능)");
        return validCount(Console.readLine().trim());
    }

    public int validCount(String inputCount) {
        try {
            int attemptCount = Integer.parseInt(inputCount);
            if (attemptCount < 1 || attemptCount > 1_000_000_000) {
                throw new IllegalArgumentException("시도 횟수는 1 이상 1,000,000,000 이하의 숫자여야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgException("숫자만 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            throw new CustomIllegalArgException(e.getMessage());
        }
    }

}
