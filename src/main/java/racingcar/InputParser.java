package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public List<Car> parseCarName(String carName) {
        String[] names = carName.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
            cars.add(new Car(name));
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1이상입니다.");
        }
        return cars;
    }

    public int parseAttemptNumber(String attemptNumber) {

        if (attemptNumber == null || attemptNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 null이거나 빈 문자열일 수 없습니다.");
        }

        try {
            return Integer.parseInt(attemptNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }
}
