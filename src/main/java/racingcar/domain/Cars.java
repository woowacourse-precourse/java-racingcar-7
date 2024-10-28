package racingcar.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cars {
    private Map<String, Integer> cars;  //String 은 자동차 이름, Integer 는 전진한 횟수이다

    public Cars(Map<String, Integer> cars) {
        carNameValidate(cars);
        this.cars = cars;
    }

    public Map<String, Integer> getCars() {
        return cars;
    }

    //자동차가 전진한 거리 업데이트 하는 메소드
    public void updateDistance(String carName, int randomNum) {
        if(randomNum >= 4) {
            int updatedDistance = cars.get(carName) + 1;
            cars.replace(carName, updatedDistance);
        }
    }

    private void carNameValidate(Map<String, Integer> cars) {
        cars.entrySet().stream()
                .forEach( entry -> {
                    String key = entry.getKey();;
                    lengthValidate(key);    //자동차 이름 유효성 검사
                });
    }

    //자동차 이름 길이 유효성 검사 메소드
    private void lengthValidate(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 차 이름은 5자 이하여야 합니다");
        }
        else if(carName.length() <= 0) {
            throw new IllegalArgumentException("[ERROR] 차 이름은 공백일 수 없습니다");
        }
    }
}
