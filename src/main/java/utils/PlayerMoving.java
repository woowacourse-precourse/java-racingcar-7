package utils;

import constant.Constants;

public class PlayerMoving {
    public static boolean isMoving(){
        return (RandomNumberGenerator.createMovingNumber() >= Constants.MOVING_CRITERIA);
    }
}
