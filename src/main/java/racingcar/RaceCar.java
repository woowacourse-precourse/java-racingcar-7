package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class RaceCar {
    public String[] splitNames(String getCarNames){
        String[] cars= getCarNames.split(",");
        return cars;
    }
}
