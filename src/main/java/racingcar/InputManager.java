package racingcar;

import camp.nextstep.edu.missionutils.Console;
import constant.Constants;
import validator.Validator;

public class InputManager {

    public static String inputPlayerGroup(){
        System.out.println(Constants.RACING_CAR_INPUT_MASSEAGE);
        return Console.readLine();
    }

    public static int inputRacingTurn(){
        System.out.println(Constants.RACING_TURN_INPUT_MESSAGE);
        String orinalInput = Console.readLine();
        Validator.validatePlayerTurn(orinalInput);
        return Integer.parseInt(orinalInput);
    }
}
