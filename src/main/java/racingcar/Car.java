package racingcar;

public class Car {

    private String carName;
    private int racingCount = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getRacingCount() {
        return racingCount;
    }

    public String getCarName() {
        return carName;
    }

    public void drive(boolean canMove) {
        if (canMove) {
            racingCount++;
        }
    }

    public void showRacingCarCompetition() {
        System.out.println(carName + " : " + "-".repeat(racingCount));
    }
}
