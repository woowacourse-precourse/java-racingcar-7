package racingcar;

class Car {
    private static final int MOVEMENT_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int moveDistance) {
        if (moveDistance >= MOVEMENT_THRESHOLD) {
            this.position++;
        }
    }
}
