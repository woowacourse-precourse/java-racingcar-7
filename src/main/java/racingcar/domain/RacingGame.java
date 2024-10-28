package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.validator.Validator;

public class RacingGame {

    private final String BLANK_STRING = "";
    private final String RACE_LINE = "-";
    private final Integer INITIAL_NUMBER = 0;


    private Map<String,String> carData;
    private Integer maxLength;
    private List<String> resultList;

    public RacingGame(List<String> names){
        validateNames(names);
        this.carData = generateMap(names);
        this.maxLength = INITIAL_NUMBER;
        this.resultList = new ArrayList<>();
    }

    public void setMovement(String name){
        if(carData.containsKey(name)){
            String movement = carData.get(name) + RACE_LINE;
            carData.put(name,movement);
        }
    }

    public Set<String> getKeys(){
        return carData.keySet();
    }

    public Map<String, String> getCarData(){
        return carData;
    }

    public List<String> getGameWinner(){
        for(String name : carData.keySet()){
            checkMaxLength(name);
        }

        return resultList;
    }

    private void validateNames(List<String> names) throws IllegalArgumentException {
        Validator.validateCarNameBlank(names);
        Validator.validateCarNameLength(names);
        Validator.validateDuplicatedCarName(names);
    }

    private Map<String, String> generateMap(List<String> names) {
        Map<String, String> newCarData = new HashMap<>();
        names.stream().forEach(name -> newCarData.put(name, BLANK_STRING));
        return newCarData;
    }

    private void checkMaxLength(String name) {
        String distance = carData.get(name);

        if (distance.length() > maxLength) {
            maxLength = distance.length();
            resultList.clear();
            resultList.add(name);
        } else if (distance.length() == maxLength) {
            resultList.add(name);
        }

    }

}
