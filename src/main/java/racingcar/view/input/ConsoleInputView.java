package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    @Override
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public String readRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
