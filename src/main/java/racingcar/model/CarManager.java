package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarManager { // TODO: 모델 이름 다시 생각해보기
    private List<Car> cars;

    public CarManager() {
        this.cars = new ArrayList<>();
    }

    public void initialize(List<String> names) {
        for (String name : names) {
            Car car = new Car(name, 0);
            cars.add(car); // 생성된 Car 객체를 리스트에 추가
        }
    }

//    public List<Car> getCars() {
//        return cars; // 현재 관리하는 Car 객체 리스트를 반환
//    }
}
