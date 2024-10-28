package racingcar.model;

import racingcar.config.Config;
import racingcar.model.car_object.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final Set<String> userNames = new HashSet<>();
    Config config = new Config();

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(String name) {
        //중복 체크
        if (userNames.contains(name)) {
            throw new IllegalArgumentException("이미 존재하는 이름 입니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름이 빈 문자열일 수는 없습니다.");
        }
        Car car = config.car(name);
        cars.add(car);
        userNames.add(name);
    }
}
