package racingcar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RacingGame {
    CarNameValidator carNameValidator = new CarNameValidator();
    final private LinkedHashMap<String, Integer> cars = new LinkedHashMap<>();

    public LinkedHashMap<String, Integer> getCarNumber() {
        groupCars();
        carNameValidator.checkLengthCarNames();
        for (int i=0; i<carNameValidator.changeTryTimesNumber(); i++) {
            for (Map.Entry<String, Integer> entry : cars.entrySet()) {
                if (RandomNumbersPicker.pickRandomNumbers() > 3 ) {
                    //System.out.println(entry.getKey()+"val"+entry.getValue());
                    cars.put(entry.getKey(), entry.getValue()+1);
                }

                System.out.println(entry.getKey()+ " : " + "-".repeat(entry.getValue()));
            }

        }
        System.out.println(cars);
        return cars;
    }

    public LinkedHashMap<String, Integer> groupCars() {

        for (int i=0; i<carNameValidator.separateCarNames().length; i++){
            cars.put(carNameValidator.separateCarNames()[i], 0);
        }
        return cars;
    }

}
