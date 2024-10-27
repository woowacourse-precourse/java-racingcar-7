package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.view.constants.Notice.ASK_CAR_NAMES;
import static racingcar.view.constants.Notice.ASK_TOTAL_ROUNDS;

public class InputView {
    public static String requestCarNames(){
        System.out.println(ASK_CAR_NAMES.getMessage());
        return Console.readLine();
    }

    public static String requestTotalRounds(){
        System.out.println(ASK_TOTAL_ROUNDS.getMessage());
        return Console.readLine();
    }

}
