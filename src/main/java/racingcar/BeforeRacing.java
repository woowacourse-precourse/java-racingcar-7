package racingcar;

import java.util.ArrayList;
import java.util.List;

public class BeforeRacing {

    public static List<String> divideCarName(String carName) {
        List<String> carNameList = new ArrayList<>();
        String[] split = carName.split(",");
        for (String name : split) {
            carNameList.add(name.trim());
        }
        return carNameList;
    }

}
