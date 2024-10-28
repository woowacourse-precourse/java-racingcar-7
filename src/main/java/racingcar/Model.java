package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Model {

    public static List Cars(String names) {
        String b = names.trim().replaceAll("\\s+", "");
        ArrayList<String> a = new ArrayList<>(Arrays.asList(b.split(",")));
        return a;
    }

    public static int RandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean Advance(int num) {
        if(num >= 4) return true;
        else return false;
    }

}
