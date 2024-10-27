package racingcar.util;

import java.util.ArrayList;
import java.util.Collections;

public class NameParser {
    public static ArrayList<String> parse(String names) {
        ArrayList<String> nameList = new ArrayList<>();
        Collections.addAll(nameList, names.split(","));
        validName(nameList);
        return nameList;
    }

    public static void validName(ArrayList<String> nameList) {
        if (nameList.size() == 0) {
            throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
        }

        nameList.stream()
                .filter(String::isBlank)
                .forEach(name -> {
                    throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
                });
    }
}
