package racingcar;

import java.util.ArrayList;

// TODO: 일급 컬렉션에 부합하는지 좀 더 고려
public class Cars {
    private static final int SPLIT_ALL = -1;
    private static final String DELIMITER = ",";

    private final ArrayList<Car> cars;

    public Cars(String names) {
        cars = new ArrayList<>();
        for (String name : names.split(DELIMITER, SPLIT_ALL)) {
            cars.add(new Car(name));
        }
    }

    public int count() {
        return cars.size();
    }

    public String nameAt(int index) {
        return cars.get(index).getName();
    }

    public int countMoveAt(int index) {
        return cars.get(index).countMove();
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public ArrayList<String> winnerNames() {
        int maxMovedCount = -1;
        ArrayList<String> names = new ArrayList<>(cars.size()); // 오버헤드를 방지하기 위해, 최대 사이즈만큼 미리 할당

        for (Car car : cars) {
            if (maxMovedCount > car.countMove()) {
                continue;
            }

            if (maxMovedCount < car.countMove()) {
                maxMovedCount = car.countMove();
                names.clear();
            }

            names.add(car.getName());
        }
        return names;
    }
}
