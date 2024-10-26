package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CarsNameParser {


    static Set parse(String carNamesInput){
        Set<String> carNames = new HashSet<>();
        for(String carName :carNamesInput.split(",")) {
            carNames.add(carName.trim());
        }
        return carNames;
    }








}
