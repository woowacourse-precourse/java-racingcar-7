package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    /* 자동차 클래스 관리 클래스 생성 - 0
    * - 우승 자동차 결정 기능
    * - 우승 자동차 출력 기능
    * - 우승자가 여러 명일 경우, 쉼표(,)를 이용하여 구분한다.
    * 잘못된 값이 입력될 경우 IllegalArgumentException을 발생시키고 에플리케이션을 종료한다.
     */

    private List<Car> cars;

    public Cars(List<String> names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars(){
        return cars;
    }
}
