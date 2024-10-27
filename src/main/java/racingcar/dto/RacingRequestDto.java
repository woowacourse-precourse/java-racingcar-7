package racingcar.dto;

public class RacingRequestDto {

    private final String carNames;
    private final int tryCountNumber;

    public RacingRequestDto(final String carNames, final int tryCountNumber) {
        this.carNames = carNames;
        this.tryCountNumber = tryCountNumber;
    }

    public String getCarNames() {
        return this.carNames;
    }

    public int getTryCountNumber() {
        return this.tryCountNumber;
    }
}
