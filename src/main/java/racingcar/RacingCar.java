package racingcar;

public class RacingCar {
    private final String name;
    private int status;

    public RacingCar(String name) {
        this.name = name;
    }

    public void run(boolean move) {
        if (move) {
            status++;
        }
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, status));
    }
}
