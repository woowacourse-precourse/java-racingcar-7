package car;

public class Car {

    private String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String carName) {
        return new Car(carName, 0);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position += 1;
    }
}
