package racingcar.constant;

public final class RacingCarError {

    public static String INVALID_CAR_NAME( String name ) {
        return String.format( "올바르지 않은 자동차 이름입니다: %s", name );
    }

    public static final String INVALID_TRY_CNT = "올바르지 않은 시도횟수 입력입니다.";

}
