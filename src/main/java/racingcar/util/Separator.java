package racingcar.util;

import java.util.List;

public class Separator {

    String delimiter = ",";

    public List<String> separateVehicleList(String vehicleListInput) {
        List<String> vehicleList = List.of(vehicleListInput.split(delimiter));
        return vehicleList;
    }

}
