package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constants;

import static racingcar.Constants.INPUT_MESSAGE;
import static racingcar.Constants.INPUT_ROUNDNUMBER;

public class InputView {

    public static String setCarName(){
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String setRoundNumber(){
        System.out.println(INPUT_ROUNDNUMBER);
        return Console.readLine();
    }
}
