package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static final int NAME_MAX = 5;
    private List<Car> cars;
    private int tryCount;

    public void ready() {
        String inputNames = readLine();
        cars = createCars(createNames(inputNames));

        String tryCountStr = readLine();
        tryCount = changeTryCountToInt(tryCountStr);
    }

    public String[] createNames(String inputNames) {
        String[] names = inputNames.split(",");
        for (String name : names) {
            if (name.length() > NAME_MAX) {
                throw new IllegalArgumentException("차의 이름은 5글자 이하여야 합니다");
            }
        }
        return names;
    }

    public ArrayList<Car> createCars(String[] names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public int changeTryCountToInt(String tryCountStr) {
        int tryCount = Integer.parseInt(tryCountStr);
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1이상 이어야 합니다");
        }
        return tryCount;
    }
}
