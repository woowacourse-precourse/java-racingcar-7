package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static final int NAME_MAX = 5;
    private List<Car> cars;
    private int tryCount;

    public void ready(String[] names, int tryCount) {
        this.cars = createCars(names);
        this.tryCount = tryCount;
    }

    public List<Car> startRound() {
        for (Car car : cars) {
            car.goAndStop();
        }
        return cars;
    }

    public List<String> end() {
        return findWinners(cars);
    }

    private List<String> findWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.getForwardCount(), max);
        }
        for (Car car : cars) {
            if (car.getForwardCount() == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public ArrayList<Car> createCars(String[] names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public String[] createNames(String inputNames) {
        String[] names = inputNames.split(",");
        for (String name : names) {
            if (name.length() > NAME_MAX) {
                throw new IllegalArgumentException("차의 이름은 5글자 이하여야 합니다");
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException("이름에 공백 문자열이 입력되었습니다");
            }
        }
        return names;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
