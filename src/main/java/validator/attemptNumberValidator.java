package validator;

public class attemptNumberValidator {
    
    public static void checkAttempt(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
