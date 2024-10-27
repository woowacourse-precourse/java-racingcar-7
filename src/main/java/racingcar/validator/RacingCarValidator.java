package racingcar.validator;

import racingcar.util.ExceptionMessage;

public class RacingCarValidator {

    public static void isValidCarName(String carName){
        if (carName.length() > 5 || carName.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessage.CARNAGE_EXCEPTION.getExceptionMessage());
        }
    }


    public static boolean canForward(int randomNumber){
        return (randomNumber >= 4);
    }


    public static int validateRacingAttemptCount(String racingAttemptCountString) {
        int racingAttemptCount = Integer.parseInt(racingAttemptCountString);
        if (racingAttemptCount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.RACING_ATTEMPT_EXCEPTION.getExceptionMessage());
        }
        return racingAttemptCount;
    }

}
