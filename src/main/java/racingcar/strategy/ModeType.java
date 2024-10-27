package racingcar.strategy;

public enum ModeType {
    RACING_CAR,
    SPORT_CAR,
    PRACTICE_CAR;

    public static Mode createCarMode(ModeType modeType) {
        if (modeType.equals(ModeType.RACING_CAR)) {
            return new RacingCar();
        }
        if (modeType.equals(ModeType.SPORT_CAR)) {
            return new SportCar();
        }
        return new PracticeCar();
    }
}
