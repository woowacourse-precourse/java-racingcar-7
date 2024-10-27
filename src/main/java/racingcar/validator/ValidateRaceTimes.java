package racingcar.validator;

import java.util.regex.Pattern;

public class ValidateRaceTimes {
    private static final Pattern RACE_TIMES_PATTERN = Pattern.compile("/^[0-9]*$/");

    public void containsCharacters(String raceTimes) {
        if (!RACE_TIMES_PATTERN.matcher(raceTimes).matches()) {
            throw new IllegalArgumentException("숫자 이외의 문자가 포함되어 있습니다.");
        }
    }

    public void isBlank(String raceTimes) {
        if (raceTimes == null || raceTimes.isBlank()) {
            throw new IllegalArgumentException("시도 횟수는 빈 값이 될 수 없습니다.");
        }
    }
}
