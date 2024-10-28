package model;

import message.Message;

import java.util.Arrays;
import java.util.List;

public class RacingCar {

    private List<String> parseCarName(String carsInput){

        String delimiter = ",";
        String [] inputCarTokens = carsInput.split(delimiter);

        for (String token : inputCarTokens) {
            if (token.length() > 5) throw new IllegalArgumentException("차 이름은 5글자 이하여야 합니다.");
        }

        return Arrays.asList(inputCarTokens);
    }

    private int parseAttemptToInt(String attemptInput){

        try {
            int attemptInt = Integer.parseInt(attemptInput);
            return attemptInt;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ILLEGAL_ARGUMENT_ERROR.toString());
        }
    }
}
