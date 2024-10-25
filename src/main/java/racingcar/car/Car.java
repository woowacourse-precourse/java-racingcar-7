package racingcar.car;

import java.util.function.IntSupplier;

public class Car {

    private static final int MOVE_CRITERIA = 4;
    private final CarName carName;
    private final IntSupplier engine;
    private int position = 0;

    private Car(CarName carName, IntSupplier engine) {
        this.carName = carName;
        this.engine = engine;
    }


    public static Car of(String name, IntSupplier engine) {
        CarName carName = new CarName(name);
        return new Car(carName, engine);
    }

    public void move() {
        int value = engine.getAsInt();
        if (value >= MOVE_CRITERIA) {
            position++;
        }
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }
}
