package racingcar.car;

/**
 * Represents a car in a racing game. It has a <code>name</code> and a
 * <code>position</code>. The
 * position is an integer value that represents the distance the car has moved.
 *
 * @see RandomCar
 */
public abstract class Car implements Comparable<Car> {
    protected final String name;
    protected int position;

    public Car(String name) {
        checkName(name);

        this.name = name;
        this.position = 0;
    }

    /**
     * Move car toward. It will change <code>position</code> value.
     */
    abstract public void move();


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(Car other) {
        return position == other.getPosition();
    }

    @Override
    public int compareTo(Car other) {
        return position - other.getPosition();
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

    /**
     * Check if the name is valid.
     *
     * @param name the name of the car
     */
    abstract protected void checkName(String name);
}
