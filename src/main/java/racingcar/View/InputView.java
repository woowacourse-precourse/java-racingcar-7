package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.constants.Notice;

public class InputView {
    public static String requestCarNames(){
        System.out.println(Notice.ASK_CAR_NAMES);
        return Console.readLine();
    }

    public static String requestNumberOfTrials(){
        System.out.println(Notice.ASK_NUMBER_OF_TRIALS);
        return Console.readLine();
    }

}
