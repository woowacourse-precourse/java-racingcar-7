package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private List<String> positions;

    public Car(String input) {
        this.name = input;
        this.positions = new ArrayList<>();
    }

    public void move() {
        positions.add("-");
    }

    public void printCurrentPosition() {
        System.out.print(name + " : ");

        for (String position : positions) {
            System.out.print(position);
        }

        System.out.println();
    }

    public int getDistance() {
        return positions.size();
    }

    public String getName() {
        return name;
    }
}
