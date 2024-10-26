package racingcar.strategy;

public enum ModeType {
    RACING_CAR,
    SPORT_CAR,
    PRACTICE_CAR;

    public static Mode createCarMode(ModeType modeType) {
        if (modeType.equals(ModeType.RACING_CAR)) {
            return new RacingCar();
        }
        throw new IllegalArgumentException("모드 미설정 예외");
    }
}
