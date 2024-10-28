package OnGame;

public class Racing {
    private final int value;

    private Racing(final String value) {
        int convertedValue = parseInt(value);
        isValid(convertedValue);
        this.value = convertedValue;
    }

    public static Racing of(String value) {
        return new Racing(value);
    }

    public int getValue() {
        return value;
    }

    private void isValid(final int convertedValue) {
        if(convertedValue < 0) {
            throw new IllegalArgumentException("1번 이상 시도해야합니다.");
        }
    }

    private int parseInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하세요");
        }
    }
}
