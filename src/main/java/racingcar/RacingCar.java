package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static ArrayList makeNameList(String str) {
        ArrayList<String> nameList = new ArrayList<>(List.of(str.split(",")));
        return nameList;
    }
}
