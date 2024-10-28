package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.entity.Car;

public class RacingcarService {

    public List<String> parseCarName(String rawCarName) {
        return List.of(rawCarName.split(","));
    }

    public void validateCarName(List<String> parsedCarName) {
        for (String carName : parsedCarName) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("이름을 입력해 주세요.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void validateNumber(String trialCount) {
        try {
            int number = Integer.parseInt(trialCount);
            if (number <= 0) {
                throw new IllegalArgumentException("최소 1입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    public List<Car> createCar(List<String> input) {
        List<Car> cars = new ArrayList<>();
        for (String name : input) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> race(List<Car> cars) {
        for (Car car : cars) {
            int number = Randoms.pickNumberInRange(0, 9);
            car.move(number);
        }
        return cars;
    }
}
