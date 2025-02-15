package racingcar.Input;

public class Validation {

    // 빈 문자열인지 판단하는 함수
    public static void isNull(String target) {
        if (target == null || target.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }

    // 길이가 5인지 판단하는 함수
    public static void lengthOver5(String target) {
        if (target.length()>5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5자 이하만 가능합니다.");
        }
    }
}
