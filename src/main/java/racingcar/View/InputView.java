package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Exception.InputException;

public class InputView {

    public static String InputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        InputException.checkCarNames(carNames);
        return carNames;
    }

    public static int InputRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int rounds = Integer.parseInt(Console.readLine());

        InputException.checkRound(rounds);
        return rounds;
    }
}
