package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputTurnCountView {

    public String getTurnCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

}
