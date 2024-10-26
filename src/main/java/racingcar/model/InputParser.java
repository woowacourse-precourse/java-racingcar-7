package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String NAME_DELIMITER = ",";
    private static final String EMPTY_CAR_NAMES_MESSAGE = "자동차 이름이 아무것도 들어오지 않았습니다.";
    private static final String LENGTH_EXCEEDED_MESSAGE = "자동차 이름의 길이가 5를 초과하였습니다.";
    private final List<String> carNameList;

    public InputParser(String carNames){
        carNameList = new ArrayList<>();
        parseCarName(carNames);
    }

    private void parseCarName(String carNames){
        validateNotEmptyCarNames(carNames);
        for (String carName : carNames.split(NAME_DELIMITER)){
            validateLength(carName);
            carNameList.add(carName);
        }
    }

    private void validateNotEmptyCarNames(String carNames){
        if(carNames.isEmpty()){
            throw new IllegalArgumentException(EMPTY_CAR_NAMES_MESSAGE);
        }
    }

    private void validateLength(String carName){
        if (carName.length() > 5){
            throw new IllegalArgumentException(LENGTH_EXCEEDED_MESSAGE);
        }
    }

    public List<String> getCarNameList(){
        return carNameList;
    }
}
