package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Utils {
    public static ArrayList<String> toArrayList(String nameString){
        return new ArrayList<>(Arrays.asList(nameString.split(Constants.CAR_NAME_DELIMITER)));
    }
    public static int getRandomNum(){
        return Randoms.pickNumberInRange(Constants.MIN_NUM_RANGE, Constants.MAX_NUM_RAGNE);
    }

    public static String repeatDash(int position) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0,position).forEach(i -> sb.append("-"));
        return sb.toString();
    }
    public static int getMax(ArrayList<Integer> nums){
        return Collections.max(nums);
    }
}
