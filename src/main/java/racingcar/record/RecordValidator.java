package racingcar.record;

public class RecordValidator {
    private static final RecordValidator RECORD_VALIDATOR = new RecordValidator();
    private static final String IS_NOT_NUMBER = "정수 입력이 잘못 되었습니다.";
    private static final String PUT_OVER_ZERO = "시도 횟수는 0회 이상이 입력 되어야 합니다.";
    private RecordValidator(){

    }

    public static RecordValidator getInstance() {
        return RECORD_VALIDATOR;
    }

    public void numberCheck(String number){
        for(char c:number.toCharArray()){
            if(!Character.isDigit(c))
                throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }

    public void validTryTimeCheck(int tryTimes){
        if(tryTimes <= 0)
            throw new IllegalArgumentException(PUT_OVER_ZERO);
    }
}
