package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameService {
    public List<Car> getNamesFromString(String names) {
        Set<String> uniqueCheck = new HashSet<>();
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수 입력값입니다. ");
        }
        names = names.replaceAll(" ", "");
        String[] nameArray = names.split(",");

        if (nameArray.length <= 1) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }

        for (String name : nameArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
            }
            if (uniqueCheck.contains(name)) {
                throw new IllegalArgumentException("중복된 이름의 자동차가 있습니다. ");
            }
            uniqueCheck.add(name);
        }
        return makeNameList(nameArray);
    }

    private List<Car> makeNameList(String[] carNames) {
        List<Car> vehicles = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            vehicles.add(new Car(carName, 0));
        }
        return vehicles;
    }

}
