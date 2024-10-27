package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.Message;

public class Input {

    public String getCarList() {

        System.out.println(Message.INPUT_CAR_NAMES.getMessage());

        return Console.readLine();
    }

    public Integer getAttemptCount() {

        System.out.println(Message.INPUT_ATTEMPT_COUNT.getMessage());

        String num = Console.readLine();
        return Integer.parseInt(num);
    }
}
