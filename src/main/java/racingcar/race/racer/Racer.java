package racingcar.race.racer;

public abstract class Racer {
    private final String name;
    protected String distance = "";

    public Racer(String name) {
        this.name = name;
    }

    public abstract void tryMove(boolean canMove);

    public abstract boolean canMove();

    protected void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
