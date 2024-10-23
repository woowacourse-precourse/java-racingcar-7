package model;

/**
 * Represents a car in a racing game that can move forward based on certain conditions.
 * Each car has a name and maintains its position on the racing track.
 */
public class Car {
    private final String name;
    private int position = 0;

    /**
     * Constructs a new car with the specified name.
     *
     * @param name the name of the car, must not be null
     */
    public Car(String name) {
        this.name = name;
    }

    /**
     * Moves the car forward one position if the given condition is true.
     *
     * @param condition determines whether the car should move forward
     */
    public void move(boolean condition) {
        if (condition) {
            position += 1;
        }
    }

    /**
     * Returns the current position of the car on the racing track.
     *
     * @return the current position as an Integer
     */
    public int getPosition() {
        return position;
    }

    /**
     * Returns the name of the car.
     *
     * @return the car's name
     */
    public String getName() {
        return name;
    }
}