package racingcar.car.dto;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.domain.CarMessage;

public class CarRequest {
    public String enterCarNameString() {
        CarMessage.printMessage();
        return Console.readLine();
    }
}
