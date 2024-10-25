package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * The class {@code Car} represents a car with a name and a position. The car can attempt to move forward and provides
 * methods to retrieve its information.
 */
public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    /**
     * Creates a new list of {@code Car} instance from a list of car names.
     *
     * @param carNames a list of strings representing car names
     * @return {@code ArrayList<Car>}
     */
    public static List<Car> from(List<String> carNames) {
        List<Car> result = new ArrayList<>();
        for (String name : carNames) {
            result.add(new Car(name));
        }
        return result;
    }

    /**
     * A car attempt to move with 60% success rate.
     */
    public void attemptMove() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            position++;
        }
    }

    /**
     * Returns a car's information in the format: {@code "[name] : ['-' repeated by position]\n"}
     *
     * @return a string representing a car
     */
    @Override
    public String toString() {
        return name
                + " : "
                + "-".repeat(position)
                + "\n";
    }

    public int getPosition() {
        return position;
    }
}
