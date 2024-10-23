package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static ArrayList makeNameList(String str) {
        ArrayList<String> nameList = new ArrayList<>(List.of(str.split(",", -1)));
        wrongValue(nameList);
        biggerThanFive(nameList);

        return nameList;
    }

    private static void biggerThanFive(ArrayList<String> nameList) {
        for (String s : nameList) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("5자를 넘었습니다.");
            }
        }
    }

    private static void wrongValue(ArrayList<String> nameList) {
        if (nameList.contains("")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
