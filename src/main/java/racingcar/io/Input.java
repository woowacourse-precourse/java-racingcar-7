package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.Message;

public class Input {

    private String inputMessage;

    public String getCarList() {

        inputMessage = String.format(Message.INPUT_CAR_NAMES.getMessage());
        System.out.println(inputMessage);

        return Console.readLine();
    }

    public Integer getAttemptCount() {

        inputMessage = String.format(Message.INPUT_ATTEMPT_COUNT.getMessage());
        System.out.println(inputMessage);

        String num = Console.readLine();
        return Integer.parseInt(num);
    }
}
