package racingcar.race.manager;

public enum ManagerConstant {
    ROUND_OUT_OF_RANGE(1, 5, "1 이상의 5이하 숫자를 입력해야합니다."),
    CAR_NAME_OUT_OF_RANGE(2, 5, "2개 이상 5개 이하로 제한하고 있습니다.");

    private final int minimumThreshold;
    private final int maximumThreshold;
    private final String errorMessage;

    ManagerConstant(int minimumThreshold, int maximumThreshold, String errorMessage) {
        this.minimumThreshold = minimumThreshold;
        this.maximumThreshold = maximumThreshold;
        this.errorMessage = errorMessage;
    }

    public void validate(int value) {
        if (value < minimumThreshold) {
            throw new IllegalArgumentException(errorMessage);
        }

        if (value > maximumThreshold) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
