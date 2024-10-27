package racingcar.validation;

import static racingcar.constant.RacingCarError.INVALID_CAR_NAME;
import static racingcar.constant.RacingCarError.INVALID_TRY_CNT;

public class Validator {
    public static String checkCarName( String carName ) {
        if ( !carName.matches( "[가-힣\\w\\d\\-]{1,5}" ) )
            throw new IllegalArgumentException( INVALID_CAR_NAME( carName ) );

        return carName;
    }

    public static void checkTryCnt(int tryCnt ) {
        if ( tryCnt < 1 )
            throw new IllegalArgumentException(INVALID_TRY_CNT);
    }
}
