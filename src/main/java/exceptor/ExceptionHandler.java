package exceptor;

import static inspector.InspectName.letterCounter;

import constant.Constants;

public class ExceptionHandler {
    public static void detectInvalidPlayerTurn(String inputTurn){
        try{
            int convertedTurn = Integer.parseInt(inputTurn);
            detectNegativeIntegerPlayerTurn(convertedTurn);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("입력한 값이 정수가 아님");
        }
    }
    public static void detectNegativeIntegerPlayerTurn(int turn){
        if(turn < 0){
            throw new IllegalArgumentException("입력한 값이 음수임");
        }
    }

    public static void detectNameLengthSatisfyingCriteria(String name){
        if(letterCounter(name) > Constants.RACING_CAR_NAME_LIMIT){
            throw new IllegalArgumentException("글자 수가 기준보다 많음");
        }
    }
}
