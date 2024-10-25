package racingcar.controller;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<String> parseNamesToList(String nameInput) {
        try {
            String[] split = nameInput.split(",");
            return Arrays.stream(split).toList();
        } catch (Exception e) {
            throw new IllegalArgumentException("이름 입력이 잘못되었습니다.");
        }
    }

    public long parseTimesToLong(String timeInput) {
        try {
            return Long.parseLong(timeInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("횟수 입력이 잘못되었습니다.");
        }
    }
}
