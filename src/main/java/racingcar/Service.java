package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    private Map<String,String> CARMAP = new HashMap<>();
    private final String RACE_LINE = "-";
    private final String RACING_OUTPUT = " : ";
    private final String COMMA_STRING = ",";
    private final String BLANK_STRING = "";
    private final Integer INITIAL_NUMBER = 0;
    private final Integer RANDOM_NUMBER_END = 9;
    private final Integer RANDOM_NUMBER_REQUIRED = 4;
    private final Integer MAX_CAR_NAME_LENGTH = 5;

    void setCarName(){
        List<String> nameList;
        try {
            nameList = getCarNameInput();
        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }

        for(String name : nameList) {
            CARMAP.put(name, BLANK_STRING);
        }
    }

    private List<String> getCarNameInput(){
        List<String> nameList = Arrays.asList(readLine().split(COMMA_STRING));
        for(String name : nameList) {
            checkCarNameLength(name);
        }

        return nameList;
    }

    private void checkCarNameLength(String name) {
        if (name.length() == INITIAL_NUMBER || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    void goCarMovement(Integer count){
        for(int i=INITIAL_NUMBER; i<count; i++){
            asfwe();
            System.out.println();
        }
    }

    private void asfwe(){
        for(var name : CARMAP.keySet()){
            goRandomMovement(name);
            System.out.println(name + RACING_OUTPUT + CARMAP.get(name));
        }
    }

    private void goRandomMovement(String name) {
        Integer num = pickNumberInRange(INITIAL_NUMBER,RANDOM_NUMBER_END);

        if(num>=RANDOM_NUMBER_REQUIRED){
            String movement = CARMAP.get(name) + RACE_LINE;
            CARMAP.put(name,movement);
        }
    }

    String getWinner(){
        List<String> resultList = new ArrayList<>();
        Integer maxLength = INITIAL_NUMBER;
        for(String car : CARMAP.keySet()) {
            maxLength = getMaxRaceLine(resultList, car, maxLength);
        }
        return String.join(COMMA_STRING, resultList);
    }

    private Integer getMaxRaceLine(List<String> resultList, String car, Integer maxLength){
        String value = CARMAP.get(car);

        if (maxLength < value.length()) {
            maxLength = value.length();
            resultList.clear();
            resultList.add(car);
        } else if (maxLength == value.length()){
            resultList.add(car);
        }
        return maxLength;
    }

}
