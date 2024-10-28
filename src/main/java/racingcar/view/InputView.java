package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(",");
    }

    public int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int attempts = Integer.parseInt(Console.readLine());
            validateAttempts(attempts);
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
        }
    }
}
