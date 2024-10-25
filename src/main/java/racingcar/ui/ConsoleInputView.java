package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    public String inputCarNames() {
        System.out.println("자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분):");
        return Console.readLine();
    }

    // 반복 횟수 입력을 받는 메서드
    public int inputRepetitions() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
