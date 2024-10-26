package racingcar.service;

import java.util.HashSet;
import java.util.Set;

public class RacingCarService {

    public Set<String> splitCarName(String carNameList) {
        Set<String> carNames = new HashSet<>();
        String[] carNameArray = carNameList.split(",");

        for(String name: carNameArray){
            carNames.add(name.trim());

            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해 주세요.");
            }
        }

        return carNames;
    }
}
