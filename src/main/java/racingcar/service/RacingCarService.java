package racingcar.service;

import java.util.HashSet;
import java.util.Set;

public class RacingCarService {

    public Set<String> splitCarName(String carNameList) {
        Set<String> carNames = new HashSet<>();
        String[] carNameArray = carNameList.split(",");

        for(String name: carNameArray){
            carNames.add(name.trim());
        }

        return carNames;
    }
}
