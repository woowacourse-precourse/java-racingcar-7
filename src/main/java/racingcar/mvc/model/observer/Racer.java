package racingcar.mvc.model.observer;

public abstract class Racer implements Observer {
    protected static final String UNIT_OF_DISTANCE = "-";
    protected String name;
    protected int distance;

    public Racer(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract void update();

    @Override
    public abstract String toString();
}
