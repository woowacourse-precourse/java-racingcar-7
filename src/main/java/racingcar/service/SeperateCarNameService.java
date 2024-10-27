package racingcar.service;


import java.util.ArrayList;
import racingcar.model.Cars;

public class SeperateCarNameService {

    private static final String BASIC_DELIMETER = ",";

    public Cars seperateCarNameFromCarNamesWithDelimeter(final String carNamesWithDelimeter){

        String[] carNames = carNamesWithDelimeter.split(BASIC_DELIMETER);

        return new Cars(carNames);

    }

}
