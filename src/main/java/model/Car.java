package model;

public class Car {

    private final static int INIT_STEP = 0;
    private final static int MOVE_STEP = 1;

    private final String name;
    private int step;

    public Car(String name) {
        this.name = name;
        this.step = INIT_STEP;
    }

    public void move() {
        this.step += MOVE_STEP;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

}
