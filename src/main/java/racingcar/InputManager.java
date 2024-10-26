package racingcar;

import camp.nextstep.edu.missionutils.Console;
import constant.Constants;
import exceptor.Validator;

public class InputManager {

    public static String inputPlayerGroup(){
        System.out.println(Constants.RACING_CAR_INPUT_MASSEAGE);
        return Console.readLine();
    }

    public static int inputTurn(){
        System.out.println(Constants.RACING_TRIAL_INPUT_MESSAGE);
        String turn = Console.readLine();
        Validator.validatePlayerTurn(turn);
        return Integer.parseInt(turn);
    }
}
