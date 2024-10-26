package racingcar.service;


import java.util.ArrayList;
import racingcar.model.Cars;

public class SeperateCarNameService {

    private static final String BASIC_DELIMETER = ",";

    public Cars seperate(final String carNamesWithDelimieter){

        String[] carNames = carNamesWithDelimieter.split(BASIC_DELIMETER);

        return new Cars(carNames);

    }

}
