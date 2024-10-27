package model;

import java.util.ArrayList;
import java.util.stream.Collectors;
import service.MoveStrategy;

/**
 * Represents a car racing game where multiple cars compete.
 * Manages the movement and position of cars and determines winners.
 */
public class Race {
    private final ArrayList<Car> cars;

    /**
     * Constructs a new race with the given car names.
     * Creates a car instance for each provided name.
     *
     * @param names list of car names to participate in the race
     */
    public Race(ArrayList<String> names) {
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    /**
     * Moves all cars in the race according to the movement strategy.
     * Each car's movement is determined by the MoveStrategy.
     */
    public void moveCars() {
        for (Car car : cars) {
            car.move(MoveStrategy.moveOrNot());
        }
    }

    /**
     * Returns all cars that have reached the furthest position in the race.
     * Multiple cars can be winners if they share the same maximum position.
     *
     * @return list of winning cars
     */
    public ArrayList<Car> getWinners() {
        int maxPosition = findMaxPosition();
        return filterWinningCars(maxPosition);
    }

    /**
     * Returns all cars participating in the race.
     *
     * @return list of all cars in the race
     */
    public ArrayList<Car> getCars() {
        return cars;
    }

    /**
     * Finds the maximum position reached by any car in the race.
     *
     * @return the maximum position value
     */
    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    /**
     * Filters cars that have reached the specified position.
     *
     * @param maxPosition the position to filter cars by
     * @return list of cars at the specified position
     */
    private ArrayList<Car> filterWinningCars(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}