package racingcar;

import java.util.ArrayList;

// TODO: 일급 컬렉션에 부합하는지 좀 더 고려
public class Cars {
    private final ArrayList<Car> cars;

    // TODO: String 받을지 고려
    // TODO: 이름이 0자일 때 고려
    public Cars(CarNameParser parser) {
        cars = new ArrayList<>();
        while (parser.hasMoreName()) {
            cars.add(new Car(parser.nextName()));
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
