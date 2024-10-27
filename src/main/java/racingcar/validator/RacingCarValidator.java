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
        try{
            int racingAttemptCount = Integer.parseInt(racingAttemptCountString);
            validatePositiveNumber(racingAttemptCount);
            return racingAttemptCount;
        } catch (Exception e){
            throw new IllegalArgumentException(ExceptionMessage.RACING_ATTEMPT_EXCEPTION.getExceptionMessage());
        }
    }


    private static void validatePositiveNumber(int number){
        if (number <= 0)
            throw new IllegalArgumentException(ExceptionMessage.RACING_ATTEMPT_EXCEPTION.getExceptionMessage());
    }



}
