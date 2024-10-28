package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int count = Integer.parseInt(Console.readLine());
            if (count <= 0) {
                throw new IllegalArgumentException();
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}