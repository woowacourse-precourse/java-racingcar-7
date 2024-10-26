package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.validator.Validator;

public class Cars {
    private static Map<String,String> cars = new HashMap<>();

    public static void register(List<String> names){
        for(String name : names){
            Validator.validateCarName(name);
            cars.put(name,"");
        }
    }

    public static Map<String,String> moveForward(){
        for(String key:cars.keySet()){
            int random = Randoms.pickNumberInRange(0, 9);
            if(random>=4){
                cars.put(key,cars.get(key)+"-");
            }
        }
        return cars;
    }
}
