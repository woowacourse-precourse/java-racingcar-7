package racingcar.domain;

public record RacingCarName(String racingCarName) {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public RacingCarName {
        ValidateCarNameLength(racingCarName);
    }
    private void ValidateCarNameLength(final String carName){
        if (carName.isEmpty() || carName.length() > CAR_NAME_MAX_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 1자리 이상 5자 이하만 가능합니다.");
        }
    }
}
