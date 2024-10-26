package racingcar.model;

import java.util.ArrayList;

public class InputParser {
    private static final String NAME_DELIMITER = ",";
    private static final String LENGTH_EXCEEDED_MESSAGE = "자동차 이름의 길이가 5를 초과하였습니다.";
    private final ArrayList<String> carNameList;

    public InputParser(String carNames){
        carNameList = new ArrayList<>();
        parseCarName(carNames);
    }

    private void parseCarName(String carNames){
        for (String carName : carNames.split(NAME_DELIMITER)){
            validateLength(carName);
            carNameList.add(carName);
        }
    }

    private void validateLength(String carName){
        if (carName.length() > 5){
            throw new IllegalArgumentException(LENGTH_EXCEEDED_MESSAGE);
        }
    }

    public ArrayList<String> getCarNameList(){
        return carNameList;
    }
}
