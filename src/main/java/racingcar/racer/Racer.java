package racingcar.racer;

public abstract class Racer {
    private final String name;
    private String distance = "";

    public Racer(String name) {
        this.name = name;
    }

    public void tryMove() {
        if (canMove()) {
            distance += "-";
        }
    }

    public abstract boolean canMove();

    public String getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
