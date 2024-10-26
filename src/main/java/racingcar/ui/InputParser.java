package racingcar.ui;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputParser {

    public String[] parseNames(String names) {
        String[] splitNames = names.split(",");
        validateNameFormat(splitNames);
        validateDuplicateName(splitNames);
        return splitNames;
    }

    public int parseTryCount(String stringTryCount) {
        try {
            int tryCount = Integer.parseInt(stringTryCount);
            isPositiveNum(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 양수만 입력 가능합니다.");
        }
    }

    private void validateNameFormat(String[] splitNames) {
        for (String name : splitNames) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private void validateDuplicateName(String[] splitNames) {
        Set<String> nameSet = Arrays.stream(splitNames)
                .collect(Collectors.toSet());

        if (splitNames.length != nameSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private void isPositiveNum(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("시도횟수는 0 또는 음수일 수 없습니다.");
        }
    }
}
