package racingcar.utility;

public class Utils {
    public enum TryNumberBoundary{
        MIN_TRY_NUMBER(1),
        MAX_TRY_NUMBER(100);

        final private int message;

        public int getMessage(){
            return message;
        }

        TryNumberBoundary(int message) {
            this.message = message;
        }
    }


    public static int checkTryNumberInteger(String tryNum){
        int tryNumber = 0;
        try{
            tryNumber = Integer.parseInt(tryNum);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("시도횟수가 양의 정수의 값이 아닙니다.");
        }
        return tryNumber;
    }
    public static void checkTryNumberRange(int tryNum){
        if(tryNum < TryNumberBoundary.MIN_TRY_NUMBER.getMessage()) throw new IllegalArgumentException("시도횟수가 최소 횟수보다 작습니다.");
        if(tryNum > TryNumberBoundary.MAX_TRY_NUMBER.getMessage()) throw new IllegalArgumentException("시도횟수가 최대 횟수보다 큽니다.");
    }
    public static void checkEmptyInput(String userInputcarsName){
        if(userInputcarsName.isEmpty()) throw new IllegalArgumentException("빈문자열을 입력했습니다.");
        if(userInputcarsName == null) throw new IllegalArgumentException("null값이 들어왔습니다.");
    }
}
