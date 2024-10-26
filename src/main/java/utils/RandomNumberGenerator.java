package utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static constant.Constants.RACING_NUMBER_MINIMUM;
import static constant.Constants.RACING_NUMBER_MAXIMUM;

public class RandomNumberGenerator {
    public static int createMovingNumber(){
        return pickNumberInRange(RACING_NUMBER_MINIMUM, RACING_NUMBER_MAXIMUM);
    }
}
