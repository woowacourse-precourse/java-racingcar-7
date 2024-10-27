package racingcar.component;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car implements Comparable<Car> {
    private static final Map<String, Integer> nameCount = new HashMap<>();

    private static final int MOVING_FORWARD = 4;
    private static final String NAME_REGEX = "^[a-zA-Z]{1,5}$";
    private static final String DELIMITER = ",";

    private final String name;
    private int position;

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    @Override
    public String toString() {
        return name;
    }

    public static List<Car> makeListFrom(String carsString) {
        validateCarsString(carsString);

        return Arrays.stream(carsString.split(DELIMITER))
                .map(Car::new)
                .toList();
    }

    private static void validateCarsString(String carsString) {
        if (!carsString.matches("^[a-zA-Z]{1,5}(,[a-zA-Z]{1,5}){0,4}$")) {
            throw new IllegalArgumentException();
        }
    }

    Car(String name) {
        validateName(name);

        this.name = addSuffixIfDuplicated(name);
        this.position = 0;
    }

    private void validateName(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    private String addSuffixIfDuplicated(String name) {
        int suffix = getSuffix(name);

        if (suffix != 0) {
            return name + suffix;
        }
        return name;
    }

    private int getSuffix(String name) {
        int count = nameCount.getOrDefault(name, 0);
        nameCount.put(name, count + 1);

        return count;
    }

    public void moveOrNot() {
        if (canMove()) {
            move();
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVING_FORWARD;
    }

    private void move() {
        position++;
    }

    public boolean isSamePosition(Car other) {
        return position == other.position;
    }

    public void printPosition() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    static void clearNameCount() {
        nameCount.clear();
    }
}
