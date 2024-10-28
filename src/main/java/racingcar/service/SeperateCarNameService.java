package racingcar.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.model.Cars;

public class SeperateCarNameService {

    private static final String BASIC_DELIMETER = ",";

    public Cars seperateCarNameFromCarNamesWithDelimeter(final String carNamesWithDelimeter){

        String[] carNames = carNamesWithDelimeter.split(BASIC_DELIMETER);

        return new Cars(Arrays.stream(carNames).collect(Collectors.toList()));

    }

}
