package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.global.Message;

public class InputView {

    public String getCarName() {
        System.out.println(Message.ENTER_CAR_NAMES);
        return readLine();
    }

    public int getTryCounts() {
        System.out.println(Message.ENTER_TRY_COUNT);
        return Integer.parseInt(readLine());
    }
}
