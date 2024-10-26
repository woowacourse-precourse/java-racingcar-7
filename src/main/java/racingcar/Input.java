package racingcar;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Input {
    public void validateBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력에 공백이 포함되어 있습니다.");
        }
    }

    public void validateEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("문자열 입력이 필요합니다.");
        }
    }

    public void validateNameLength(String input) {
        if (Arrays.stream(input.split(","))
                .anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("차 이름은 5자 이하로 작성해야 합니다.");
        }
    }

    public void validateDuplicate(String input) {
        Set<String> cars = new HashSet<>();
        for (String s : input.split(",")) {
            if (!cars.add(s)) {
                throw new IllegalArgumentException("차 이름은 중복될 수 없습니다.");
            }
        }
    }
}