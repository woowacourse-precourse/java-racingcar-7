package racingcar.validator;

public class RacingCarValidator {

    public static void isValidCarName(String carName){
        if (carName.length() > 5 || carName.isEmpty()){
            throw new IllegalArgumentException("자동차의 이름을 잘못 입력");
        }
    }


    public static boolean canForward(int randomNumber){
        return (randomNumber >= 4);
    }


    public static int canStringToInt(String racingAttemptCountString){
        try{
            return Integer.parseInt(racingAttemptCountString);
        } catch (Exception e){
            throw new IllegalArgumentException("잘못된 경주 횟수 입력");
        }
    }
}
