package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력받은 문자가 숫자가 아닌 다른 문자입니다.");
        }
    }
}
