package racingcar.domain;

public class LapScore {

    private final String carName;
    private final String visualizedMileage;

    public LapScore(String carName, String visualizedMileage) {
        this.carName = carName;
        this.visualizedMileage = visualizedMileage;
    }

    public String getCarName() {
        return carName;
    }

    public String getScore() {
        return visualizedMileage;
    }
}
