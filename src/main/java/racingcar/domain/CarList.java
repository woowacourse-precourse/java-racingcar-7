package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CarList {
    private final List<Car> carList;
    private final Set<String> carNames; // 이름 중복을 검사하기 위한 Set
    public CarList(){
        this.carList = new ArrayList<>();
    }
    public void add(Car car){
        validateDuplicateName(car.getName());
        carList.add(car);
        carNames.add(car.getName());
    }
    // 이름 중복 확인 method
    private void validateDuplicateName(String name) {
        if (carNames.contains(name)) {
            throw new IllegalArgumentException("이미 존재하는 자동차 이름입니다: " + name);
        }
    }
    public List<Car> getCars() {
        return new ArrayList<>(carList);
    }
}
