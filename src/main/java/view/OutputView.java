package view;

import model.Car;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Handles the output display for the car racing game.
 * This class is responsible for displaying race progress and results.
 */
public class OutputView {

    /**
     * Prints the current state of all participating cars in the race.
     * For each car, displays its name followed by dashes representing its position.
     *
     * @param participants list of cars currently participating in the race
     */
    public void printRaceInfo(ArrayList<Car> participants) {
        for (Car car : participants) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    /**
     * Prints the final winners of the race.
     * Multiple winners are displayed in a comma-separated format.
     *
     * @param winners list of cars that achieved the highest position in the race
     */
    public void printRaceResult(ArrayList<Car> winners) {
        String result = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}