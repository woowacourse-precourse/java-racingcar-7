package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class RaceCar {
    public String[] splitNames(String carNameString){
        String[] cars= carNameString.split(",");
        for(String car :cars){
            if(car.length()>5){
                throw new IllegalStateException("자동차의 이름은 5글자를 넘길 수 없습니다");
            }
        }
        return cars;
    }
}
