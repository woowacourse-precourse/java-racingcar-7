package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.domain.enums.InterfaceMsg;

public class InputView {

    public String requestInputCarName() {
        System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue());
        String inputCarName = readLine();
        System.out.println(inputCarName);

        return inputCarName;
    }
}
