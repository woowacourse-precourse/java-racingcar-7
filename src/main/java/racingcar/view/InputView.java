package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputRoundNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
