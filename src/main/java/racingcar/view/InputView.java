package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return Console.readLine();
    }

    public int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return validateTryCount(Console.readLine());
    }

    private int validateTryCount(String count) {

        try {
            int tryCount = Integer.parseInt(count);

            if (tryCount < 1) {
                throw new IllegalArgumentException("1보다 작으면 안됩니다.");
            }

            return tryCount;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이어야 합니다.");
        }
    }

}
