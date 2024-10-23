package racingcar.util;

import static java.lang.Integer.*;

public class RacingNumberValidator {
    /**
     * Input : String
     * Check List
     * 1. The number is Number
     * 2. The number is Positive Literal
     */

    public static void checkNumberOfRacingIsAvailable(String stringNumOfRace) throws IllegalArgumentException{
        try {
            int numOfRacing = parseInt(stringNumOfRace);
            if (numOfRacing < 0) {
                throw new IllegalArgumentException("ERR : 게임의 실행 횟수가 0보다 커야합니다.");
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("ERR : 게임의 실행 횟수는 정수로 입력해주세요.");
        }
    }
}
