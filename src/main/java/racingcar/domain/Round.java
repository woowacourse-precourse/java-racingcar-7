package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Round {
    //라운드마다 차의 위치를 저장
    private final Map<String, Integer> carLocation = new LinkedHashMap<>();

    public void addCarLocation(String carName, int location) {
        carLocation.put(carName, location);
    }

    public Map<String, Integer> getCarLocation() {
        return carLocation;
    }

}
