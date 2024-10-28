package racingcar.model.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.dto.Car;
import racingcar.model.exception.*;

import java.util.*;

public class InputService {

    public String inputValue() {
        return Console.readLine();
    }

    public List<Car> validator(String carValue, String countValue) {
        if (carValue == null || countValue == null || carValue.isEmpty() || countValue.isEmpty()) {
            throw new MissingInputValueException("입력값이 누락되었습니다.");
        }

        if (countValue.equals("0")) {
            throw new InvalidAttemptCountException("시도할 횟수는 0일 수 없습니다.");
        }

        List<String> cars = splitCarValue(carValue);

        if (cars.size() == 1) {
            throw new InvalidCarCountException("자동차는 1개 일 수 없습니다.");
        }

        if (checkDuplicateCarName(cars)) {
            throw new DuplicateCarNameException("자동차 이름이 중복될 수 없습니다.");
        }

        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            if (car.length() > 5) {
                throw new CarNameLengthExceededException("자동차 이름의 입력값은 최대 5자입니다.");
            }
            Car carInfo = new Car(car, 0);
            carList.add(carInfo);
        }

        if (!isValidAttemptCount(countValue)) {
            throw new InvalidAttemptCountException("시도할 횟수는 숫자여야합니다.");
        }

        return carList;
    }

    public List<String> splitCarValue(String carValue) {
        return Arrays.asList(carValue.split(","));
    }

    public boolean isValidAttemptCount(String countValue) {
        try {
            Integer.parseInt(countValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkDuplicateCarName(List<String> cars) {
        Set<String> carNameSet = new HashSet<>();
        for (String car : cars) {
            if (!carNameSet.add(car)) {
                return true;
            }
        }
        return false;
    }
}
