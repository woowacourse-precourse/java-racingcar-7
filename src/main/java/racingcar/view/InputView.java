package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ServiceMessage;

public class InputView {

    public String getRacingCarInput() {
        System.out.println(ServiceMessage.START_MESSAGE_RACING_CAR_NAME.getMessage());
        return Console.readLine();
    }

    public int getRaingCountInput() {
        System.out.println(ServiceMessage.START_MESSAGE_RACING_COUNT.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
