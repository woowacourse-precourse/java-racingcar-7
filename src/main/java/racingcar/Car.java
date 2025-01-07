package racingcar;

public class Car {
    public static final int MINIMUM_MOVE_VALUE = 4;
    private static final String FORWARD_UNIT = "-";
    private static final int DEFAULT_POSITION = 0;
    private final Name name;
    private int position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public static Car createDefaultCar(String name) {
        return new Car(name, DEFAULT_POSITION);
    }

    public void move(int random) {
        if (random >= MINIMUM_MOVE_VALUE) {
            this.position++;
        }
    }

    public void printCarInfo() {
        StringBuilder forwardUnits = new StringBuilder();
        for (int i = 0; i < position; i++) {
            forwardUnits.append(FORWARD_UNIT);
        }
        System.out.printf("%s : %s%n", this.name, forwardUnits);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

}
