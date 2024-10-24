package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    public static ArrayList<String> toArrayList(String nameString){
        return new ArrayList<>(Arrays.asList(nameString.split(Constants.CAR_NAME_DELIMITER)));
    }
    public static int getRandomNum(){
        return Randoms.pickNumberInRange(Constants.MIN_NUM_RANGE, Constants.MAX_NUM_RAGNE);
    }
}
