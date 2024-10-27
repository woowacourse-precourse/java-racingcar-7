package racingcar.util;

import java.util.List;

public class Separator {

    String delimiter = ",";

    public List<String> separateCarList(String carListInput){
        List<String> carList= List.of(carListInput.split(delimiter));
        return carList;
    }

}
