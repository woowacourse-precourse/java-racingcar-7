package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.IOMessage;

public class InputView {
    public String getCar() {
        System.out.println(IOMessage.INPUT_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String getTryCount() {
        System.out.println(IOMessage.INPUT_TRY_MESSAGE.getMessage());
        return Console.readLine();
    }
}
