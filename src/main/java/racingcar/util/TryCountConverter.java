package racingcar.util;

public class TryCountConverter {

    private final String tryCount;
    private static final String POSITIVE_INTEGER = "[1-9]\\d*";
    private static final int VALID_TRY_COUNT = 30;

    public TryCountConverter(String tryCount) {
        this.tryCount = tryCount;
        validate();
    }

    private void validate() {
        isTryCountNotEmpty();
        isIntegerFormat();
    }

    private void isTryCountNotEmpty() {
        if (tryCount == null || tryCount.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 null이거나 빈 문자열입니다.");
        }
    }

    private void isIntegerFormat() {
        if (!tryCount.matches(POSITIVE_INTEGER)) { // 양의 정수만 허용
            throw new IllegalArgumentException("유효하지 않은 형식입니다.");
        }
    }

    private boolean isValidTryCount(int tryCountNum) {
        if (tryCountNum <= VALID_TRY_COUNT) {
            return true;
        }
        return false;
    }

    public int stringToInt() {
        int tryCountNum = parseTryCount(); // 문자열을 정수로 변환
        validateTryCount(tryCountNum); // 유효성 검사
        return tryCountNum; // 변환된 시도 횟수 반환
    }

    private int parseTryCount() {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다.");
        }
    }

    private void validateTryCount(int tryCountNum) {
        if (!isValidTryCount(tryCountNum)) {
            throw new IllegalArgumentException("시도 횟수가 30회 초과입니다.");
        }
    }
}
