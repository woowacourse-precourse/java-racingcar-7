package racingcar.Input;

public class Validation {
    public static void isnull (String target) {
        if (target == null || target.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }
    public static void lengthover5 (String target) {
        if (target.length()>5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5자 이하만 가능합니다.");
        }
    }
}
