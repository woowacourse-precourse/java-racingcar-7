package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class RaceCar {
    public String[] splitNames(String carNameString){
        String[] cars= carNameString.split(",");
        for(String car :cars){
            if(car.length()>5){
                System.out.println(car);
                throw new IllegalArgumentException("자동차의 이름은 다섯글자를 넘을 수 없습니다.");
            }
        }
        return cars;
    }
}
