package racingcar;

import java.util.HashMap;
import java.util.Map;

public class RacingCar {

    public void racingCars(String cars, String attempts){

        int attempt = Integer.parseInt(attempts);

        String[] car_name = cars.split(",");

        Map<String, Integer> carList = new HashMap<>();
        carList = storeCars(car_name);

    }

    private Map<String, Integer> storeCars(String[] car_name) {

        Map<String, Integer> carList = new HashMap<>();

        for(String str : car_name) {
            carList.put(str, 0);
        }
        return carList;
    }
}
