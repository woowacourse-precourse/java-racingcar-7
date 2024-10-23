package validator;

public class AttemptValidator {
    private AttemptValidator() {}

    public static void isPositiveDigit(String attempt) {
        int number;
        try {
            number = Integer.parseInt(attempt);
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 숫자를 입력해야 합니다.");
        }
        
        if (number <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수를 입력해야 합니다.");
        }
    }
}
