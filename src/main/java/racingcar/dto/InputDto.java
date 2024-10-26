package racingcar.dto;

public class InputDto {
    private String carNames;
    private int repeatCount;

    private InputDto() {}

    public static InputDto Builder() {
        return new InputDto();
    }

    public InputDto build() {
        return this;
    }

    public InputDto carNames(String carNames) {
        this.carNames = carNames;
        return this;
    }

    public InputDto repeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRepeatCount() {
        return repeatCount;
    }
}
