package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_REGEX = "^[a-zA-Z]+$";

    private static final String TRY_COUNT_REGEX = "^\\d+$";
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 10;

    public void validateCarNames(List<String> names) {
        if (isCheckedDuplicate(names)) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }

        for (String name : names) {
            validateCarName(name);
        }
    }

    public void validateCarName(String name) {
        if (isCheckedEmpty(name)) {
            throw new IllegalArgumentException("이름은 빈 값을 입력할 수 없습니다.");
        }

        if (isCheckedLength(name)) {
            throw new IllegalArgumentException("이름의 길이가 5자를 초과합니다.");
        }

        if (isCheckedEnglish(name)) {
            throw new IllegalArgumentException("이름은 영어로만 입력할 수 있습니다.");
        }
    }

    public void validateTryCount(String count) {
        if (isCheckedEmpty(count)) {
            throw new IllegalArgumentException("시도 횟수는 빈 값을 입력할 수 없습니다.");
        }

        if (isCheckedNumber(count)) {
            throw new IllegalArgumentException("시도 횟수는 숫자로만 입력할 수 있습니다.");
        }

        if (isCheckedRange(count)) {
            throw new IllegalArgumentException("시도 횟수는 1부터 10까지 입력할 수 있습니다.");
        }
    }

    private boolean isCheckedDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>();

        return names.stream().anyMatch(name -> !uniqueNames.add(name));
    }

    private boolean isCheckedEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isCheckedLength(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    private boolean isCheckedEnglish(String name) {
        return !name.matches(NAME_REGEX);
    }

    private boolean isCheckedNumber(String countStr) {
        return !countStr.matches(TRY_COUNT_REGEX);
    }

    private boolean isCheckedRange(String countStr) {
        int count = convertInt(countStr);

        return count < MIN_RANGE || count > MAX_RANGE;
    }

    private int convertInt(String countStr) {
        return Integer.parseInt(countStr);
    }

}
