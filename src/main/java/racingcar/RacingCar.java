package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static ArrayList makeNameList(String str) {
        ArrayList<String> nameList = new ArrayList<>(List.of(str.split(",", -1)));
        throwError(nameList);

        return nameList;
    }

    private static void throwError(ArrayList<String> nameList) {
        if (nameList.contains("")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
