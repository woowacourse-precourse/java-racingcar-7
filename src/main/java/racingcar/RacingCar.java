package racingcar;

public class RacingCar {
    private final String name;
    private String currentMovingPoint = "";

    public RacingCar(String name, String currentMovingPoint) {
        this.name = name;
        this.currentMovingPoint = currentMovingPoint;
    }

    public String getName() {
        return name;
    }

    public String getCurrentMovingPoint() {
        return currentMovingPoint;
    }

    public void setCurrentMovingPoint(String currentMovingPoint) {
        this.currentMovingPoint = currentMovingPoint;
    }

    public String getRaceOutcomeForCarInRound(RacingCar racingCar) {
        return racingCar.name + " : " + racingCar.currentMovingPoint;
    }

    public int getCurrentMovingPointInteger() {
        return this.currentMovingPoint.length();
    }

    public void plusCurrentMovingPoint() {
        setCurrentMovingPoint(getCurrentMovingPoint() + "-");
    }
}
