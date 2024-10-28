package validator;

public class InputValidator {
    /*
    경주 횟수 검증
     */
    public static void validatePositiveInteger(int raceRounds) {
        if (raceRounds <= 0) {
            throw new IllegalArgumentException("횟수는 양의 정수여야 합니다.");
        }
    }


    public static void validateZero(int raceRounds) {
        if (raceRounds == 0) {
            throw new IllegalArgumentException("횟수는 0보다 커야 합니다.");
        }
    }


    /*
    자동차 이름 검증
     */
    public static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
