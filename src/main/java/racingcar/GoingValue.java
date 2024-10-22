package racingcar;

public enum GoingValue {
    GO,
    STOP;

    public static int MIN_INCLUDE_BOUND = 0;
    public static int MAX_INCLUDE_BOUND = 9;

    public static GoingValue from(int number) {
        validateNumberBound(number);
        if (number < 4) {
            return STOP;
        }
        return GO;
    }

    private static void validateNumberBound(int number) {
        if (number < MIN_INCLUDE_BOUND || number > MAX_INCLUDE_BOUND) {
            throw new RuntimeException("[서비스 자체 에러] 전진을 판단하는 숫자는 %d 이상, %d 이하여야 합니다."
                    .formatted(MIN_INCLUDE_BOUND, MAX_INCLUDE_BOUND)
            );
        }
    }
}
