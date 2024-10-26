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

    public int movedCountAt(int index) {
        return cars.get(index).getMovedCount();
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    // TODO: 스트림 사용 고려 혹은 리팩토링
    public ArrayList<String> winnerNames() {
        int maxMovedCount = -1;
        ArrayList<String> names = new ArrayList<>();

        for (Car car : cars) {
            if (maxMovedCount > car.getMovedCount()) {
                continue;
            }

            if (maxMovedCount < car.getMovedCount()) {
                maxMovedCount = car.getMovedCount();
                names.clear();
            }

            names.add(car.getName());
        }
        return names;
    }
}
