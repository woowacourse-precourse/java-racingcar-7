package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    private Map<String,String> CARMAP = new HashMap<>();
    private final String RACE_LINE = "-";
    private final String RACING_OUTPUT = " : ";
    private final String COMMA = ",";
    private final String BLANK_STRING = "";
    private final Integer INITIAL_NUMBER = 0;
    private final Integer RANDOM_NUMBER_END = 9;
    private final Integer REQUIRED_RANDOM_NUMBER = 4;

    void setCarName(){
        String[] inputs;
        try {
            inputs = readLine().split(COMMA);

            if (inputs.length == INITIAL_NUMBER) {
                throw new IllegalArgumentException();
            }

        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }

        for(String name : inputs)
            CARMAP.put(name, BLANK_STRING);
    }

    void goCarMovement(Integer count){
        for(int i=INITIAL_NUMBER; i<count; i++){
            for(var name : CARMAP.keySet()){
                goRandomMovement(name);
                System.out.println(name + RACING_OUTPUT + CARMAP.get(name));
            }
            System.out.println();
        }
    }

    private void goRandomMovement(String name) {
        Integer num = pickNumberInRange(INITIAL_NUMBER,RANDOM_NUMBER_END);

        if(num>=REQUIRED_RANDOM_NUMBER){
            String movement = CARMAP.get(name) + RACE_LINE;
            CARMAP.put(name,movement);
        }
    }

    String getWinner(){
        List<String> resultList = new ArrayList<>();
        Integer maxLength = INITIAL_NUMBER;
        String resultString = BLANK_STRING;

        for(var car : CARMAP.keySet()){
            String value = CARMAP.get(car);
            maxLength = max(maxLength, value.length());

            if(maxLength.equals(value.length())){
                resultList.add(car);
            }
        }

        for(var car : CARMAP.keySet()){
            String value = CARMAP.get(car);

            if(maxLength.equals(value.length())){
                resultList.add(car);

                if(resultString.length()==INITIAL_NUMBER)
                    resultString += car;
                else resultString+= COMMA +car;
            }
        }

        return resultString;
    }

}
