package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Car {
    public static final int MINIMUM_POWER = 4;
    DataManagement dataManagement = new DataManagement();
    Map<String, String> currentCarData = dataManagement.getCarData();

    public int currentPower(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public String currentDistance(String carName){
        return currentCarData.get(carName);
    }

    public void move(String carName){
        currentCarData.put(carName, currentDistance(carName) + "-");
    }

    public void Status(String carName) {
        if (currentPower() >= MINIMUM_POWER) {
            move(carName);
        }
    }
}
