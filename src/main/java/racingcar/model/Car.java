package racingcar.model;

public class Car {

    private final Name name;
    private int progress;

    private Car(String name) {
        this.name = new Name(name);
        this.progress = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void forward() {
        progress++;
    }

    public String name() {
        return name.name();
    }

    public int status() {
        return progress;
    }
}
