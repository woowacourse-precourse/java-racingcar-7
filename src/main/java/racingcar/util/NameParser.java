package racingcar.util;

import java.util.ArrayList;
import java.util.Collections;

public class NameParser {
    public static ArrayList<String> parse(String names) {
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException("이름을 입력해 주세요.");
        }

        ArrayList<String> nameList = new ArrayList<>();
        Collections.addAll(nameList, names.split(","));
        return nameList;
    }
}
