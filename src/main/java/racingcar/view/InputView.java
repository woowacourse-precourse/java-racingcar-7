package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.ExceptionChecker;

public class InputView {

    public String printStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int printRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String rounds = Console.readLine();
        ExceptionChecker.validateRoundInput(rounds);

        return Integer.parseInt(rounds);
    }
}