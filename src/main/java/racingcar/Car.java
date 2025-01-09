package racingcar;

import util.NumberGenerator;

public class Car {
    private static final int MINIMUM_MOVE_VALUE = 4;
    private static final String FORWARD_UNIT = "-";
    private static final int DEFAULT_POSITION = 0;
    private final Name name;
    private int position;
    private NumberGenerator numberGenerator;

    public Car(Name name, int position, NumberGenerator numberGenerator) {
        this.name = name;
        this.position = position;
        this.numberGenerator = numberGenerator;
    }

    public static Car createDefaultCar(String name, NumberGenerator numberGenerator) {
        return new Car(new Name(name), DEFAULT_POSITION, numberGenerator);
    }

    public void move() {
        if (numberGenerator.makeNumber() >= MINIMUM_MOVE_VALUE) {
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
