package race;

public class CheckException {

    public static void checkAttempt(int attempt) {
        if (attempt <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 0 또는 음수를 허용하지 않습니다.");
        }
    }
}
