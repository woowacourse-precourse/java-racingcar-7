package utils;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    public static List<String> splitCarName(String names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_INPUT);
        }

        if (!names.matches("[가-힣a-zA-Z,]+")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }

        List<String> carNameList = Arrays.stream(names.split(","))
                .map(String::trim).toList();

        // 중복을 제거한 스트림의 크기와 실제 크기를 비교하여 중복 여부를 판단한다.
        if (carNameList.size() != carNameList.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessages.DUPLICATED_NAME);
        }
        return carNameList;
    }
}
