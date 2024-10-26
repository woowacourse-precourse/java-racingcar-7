package racingcar.model;

public class Car {
    private final Name name;
    private Distance distance;
    private static final int LIMIT = 4;

    private Car(Name name) {
        this.name = name;
        this.distance = new Distance();
    }

    public static Car getInstance(String name) {
        return new Car(Name.from(name));
    }

    public String getName() {
        return name.getName();
    }

    public Integer getDistance() {
        return distance.getDistance();
    }

    public void move(int random) {
        if (isMoveForward(random)) {
            this.distance.increase();
        }
    }

    private boolean isMoveForward(int random) {
        return random >= LIMIT;
    }
}
