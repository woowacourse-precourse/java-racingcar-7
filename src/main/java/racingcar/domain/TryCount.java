package racingcar.domain;

public class TryCount {

    private final int value;

    public TryCount(String inputTryCount) {
        validateNotEmpty(inputTryCount);
        int intTryCount = validateNumberFormat(inputTryCount);
        
        validateNegativeNumber(intTryCount);
        this.value = intTryCount;
    }

    private void validateNotEmpty(String inputTryCount) {
        if (inputTryCount.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private int validateNumberFormat(String inputTryCount) {
        try {
            return Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validateNegativeNumber(int parseTryCount) {
        if (parseTryCount < 0) {
            throw new IllegalArgumentException("유효하지 않은 시도 회수입니다.");
        }
    }

    public int getValue() {
        return value;
    }

}
