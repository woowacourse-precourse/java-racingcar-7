package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Car> cars = new ArrayList<>();

    /*
    1. 입력받은거 건네받음
    2. 이름만큼 차 생성
    3. 매번 난수 세개씩 생성
    4. 경주해서 결과 확인
     */
    public List<Car> createCars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
