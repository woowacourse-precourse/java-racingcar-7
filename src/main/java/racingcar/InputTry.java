package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputTry {

    public InputTry() { }

    public int input() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryToString = Console.readLine();
        int tries = Integer.parseInt(tryToString);
        return tries;
    }
}
