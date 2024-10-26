package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        validate(carNames);
        this.cars = new ArrayList<>(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            this.cars.add(new Car(carNames.get(i)));
        }
    }

    private void validate(List<String> carNames) {
        HashSet<String> duplicateCheck = new HashSet<>();
        for (int i = 0; i < carNames.size(); i++) {
            duplicateCheck.add(carNames.get(i));
        }
        if (duplicateCheck.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름은 등록이 불가능합니다.");
        }
    }
}
