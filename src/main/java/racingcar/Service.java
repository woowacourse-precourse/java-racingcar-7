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
    private final String COMMA = ",";
    private final String BLANK_STRING = "";
    private final Integer INITIAL_NUMBER = 0;

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
                resultString += resultString.length()==INITIAL_NUMBER ? car : COMMA +car;
            }
        }

        return resultString;
    }

}
