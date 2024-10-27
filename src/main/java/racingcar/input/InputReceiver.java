package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputReceiver {

    public String receiveCarNames() {
        return Console.readLine();
    }

    public Long receiveRaceCount() {
        return Long.parseLong(Console.readLine());
    }


}
