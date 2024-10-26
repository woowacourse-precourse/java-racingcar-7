package racingcar.validator;

public class TryCountValidator {
    private static final String NEGATIVE_NUMBER_TRY_OUT_COUNT_ERROR = "입력하신 시도할 횟수가 음수입니다.";

    public void validTryCount(int tryCount){
        if(tryCount < 0){
            throw new IllegalArgumentException(NEGATIVE_NUMBER_TRY_OUT_COUNT_ERROR);
        }
    }
}
