package racingcar.util;

import java.util.ArrayList;
import java.util.Collections;

public class NameParser {
    private static String EMPTY_NAME_ERROR_MESSAGE = "빈 이름은 허용되지 않습니다.";

    public static ArrayList<String> parse(String names) {
        ArrayList<String> nameList = new ArrayList<>();
        Collections.addAll(nameList, names.split(","));
        validNameList(nameList);
        return nameList;
    }

    public static void validNameList(ArrayList<String> nameList) {
        if (nameList.size() == 0) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }
    }
}
