package racingcar.car;

public class RacingCar {

    private String carName;
    private int distance;

    public RacingCar(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

    public void moveForwardOneStep() {
        distance += 1;
    }

    public void printMoveStatus() {
        String currentCarStatus = carName + " : " + "-".repeat(distance);
        System.out.println(currentCarStatus);
    }


}
