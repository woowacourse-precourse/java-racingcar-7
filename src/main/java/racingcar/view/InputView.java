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

    // Player로부터 자동차 경주의 회수를 입력받음
    public String requestInputCarRaceTimes() {
        System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_RACE_TIMES.getValue());
        String inputCarRaceTimes = readLine();
        System.out.println(inputCarRaceTimes);

        return inputCarRaceTimes;
    }
}
