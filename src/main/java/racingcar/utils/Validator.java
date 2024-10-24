package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;
import racingcar.model.Cars;

public class Validator {
    public static void isEmpty(String name) {
        if(name == null || name.trim().isBlank()){
            throw new IllegalArgumentException("자동차 이름에 빈칸은 입력할수 없습니다");
        }
    }

    public static void isCarNameRange(String name){
        if(name.length() >= 5){
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다");
        }
    }

    public static void containDuplicate(List<Car> cars) {
        Set<Car> uniqueCars = new HashSet<>(cars);
        if(uniqueCars.size() != cars.size()){
            throw new IllegalArgumentException("자동차의 이름은 중복될수 없습니다");
        }
    }


}
