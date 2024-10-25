package racingcar.validator;

public class TryCountValidator {
    private static final String NEGATIVE_NUMBER_TRY_OUT_COUNT_ERROR = "입력하신 시도할 횟수가 음수입니다.";
    private static final String CANNOT_CONVERT_INTO_INT_ERROR = "입력하신 시도할 횟수를 int로 변환할 수 없습니다.";
    public void validTryCount(int tryCount){
        if(tryCount < 0){
            throw new IllegalArgumentException(NEGATIVE_NUMBER_TRY_OUT_COUNT_ERROR);
        }
    }

    public int convertTryCountToInt(String stringTryCount) {
        try {
            return Integer.parseInt(stringTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CANNOT_CONVERT_INTO_INT_ERROR);
        }
    }
}
