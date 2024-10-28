package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Car {
    private String carName;
    private int moveCount;
    private final StringBuffer slashForMoveCount = new StringBuffer();
    public Car(String carName) {
        this.carName = carName;
    }

    public static List<Car> createCars(String input) {
        if (input.isBlank() || input.startsWith(",") || input.endsWith(",") || input.contains(",,")) {
            throw new IllegalArgumentException();
        }

        List<Car> cars = new ArrayList<>();
        HashSet<Integer> carNameHashCodes = new HashSet<>();
        StringTokenizer strtok = new StringTokenizer(input, ",");

        while (strtok.hasMoreTokens()) {
            String carName = strtok.nextToken().trim();
            if (carName.isBlank() || carNameHashCodes.contains(carName.hashCode()) || carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(carName));
            carNameHashCodes.add(carName.hashCode());
        }
        if (cars.size() == 1) {
            throw new IllegalArgumentException();
        }
        return cars;
    }
    public final String getCarName() {
        return carName;
    }

    public final int getMoveCount() {
        return moveCount;
    }

    public final void moveOrStay() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            ++moveCount;
            slashForMoveCount.append("-");
        }
    }

    public final StringBuffer printMoveCount() {
        StringBuffer totalMove = new StringBuffer();

        totalMove.append(carName);
        totalMove.append(" : ");
        totalMove.append(slashForMoveCount);
        totalMove.append("\n"); //result sample: "Jay : ---"

        return totalMove;
    }
}
