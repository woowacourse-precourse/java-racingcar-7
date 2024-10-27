package utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static constant.Constants.RACING_NUMBER_MAXIMUM;
import static constant.Constants.RACING_NUMBER_MINIMUM;

import constant.Constants;

public class PlayerMoving {

    public static boolean isMoveAble(){
        return (randomNumber() >= Constants.MOVING_CRITERIA);
    }

    public static int randomNumber(){
        return pickNumberInRange(RACING_NUMBER_MINIMUM, RACING_NUMBER_MAXIMUM);
    }
}
