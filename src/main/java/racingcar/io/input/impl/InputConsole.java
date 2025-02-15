package racingcar.io.input.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Round;
import racingcar.io.input.Input;

public class InputConsole implements Input {
    @Override
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public Round getRaceRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return Round.of(input);
    }
}
