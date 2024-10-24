package racingcar.io;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validators implements Validator {


    @Override
    public String[] validateString(String input) throws IllegalArgumentException {
        if (input.indexOf(",") == 0 || input.lastIndexOf(",") == input.length() - 1) {
            throw new IllegalArgumentException("잘못된 자동차 이름 입력 - 공백 이름 입력");
        }

        String[] words = splitToArray(input);
        for (String word : words) {
            if (!isLengthInRange(word)) {
                throw new IllegalArgumentException("잘못된 자동차 이름 입력 - 자동차 이름 길이 범위 벗어남");
            }
        }

        if (hasDuplicateWords(words)) {
            throw new IllegalArgumentException("잘못된 자동차 이름 입력 - 중복 이름 존재");
        }

        return words;
    }

    private String[] splitToArray(String input) {
        String[] words = input.split(",");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].strip();
        }

        return words;
    }

    private boolean isLengthInRange(String name) {
        if (name.isEmpty() || name.length() > 5) {
            return false;
        }

        return true;
    }

    private boolean hasDuplicateWords(String[] names) {
        Set<String> set = new HashSet<>(Arrays.asList(names));

        if (names.length == set.size()) {
            return false;
        }
        return true;
    }

    @Override
    public int validateInteger(String input) throws IllegalArgumentException {
        try {
            int num = Integer.parseInt(input.strip());
            if (num < 0) {
                throw new IllegalArgumentException("숫자 범위 오류");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값 입력");
        }
    }
}
