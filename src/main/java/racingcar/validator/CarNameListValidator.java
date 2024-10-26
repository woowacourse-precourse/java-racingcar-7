package racingcar.validator;

import java.util.HashSet;
import java.util.List;

public class CarNameListValidator {

    private static final int CAR_NAME_LENGTH_LIMIT = 5;

    public static void integratedValidation(List<String> carNameList) {
        emptyCarName(carNameList);
        lengthOverCarName(carNameList);
        duplicateCarName(carNameList);
    }

    private static void emptyCarName(List<String> carNameList) {
        for(String s: carNameList){
            if(s.isEmpty()) throw new IllegalArgumentException("자동차 이름은 1글자 이상이어야 합니다.");
        }
    }

    private static void lengthOverCarName(List<String> carNameList) {
        for(String s : carNameList){
            if(s.length() > CAR_NAME_LENGTH_LIMIT) throw new IllegalArgumentException("자동차 이름을 5글자 이하로 지정해야 합니다.(\"" + s + "\"이(가) 5글자 초과)");
        }
    }

    private static void duplicateCarName(List<String> carNameList) {
        HashSet<String> carNameSet = new HashSet<>();
        for(String s : carNameList){
            if(carNameSet.contains(s)){
                throw new IllegalArgumentException("자동차 이름이 중복됩니다. (\"" + s + "\"이(가) 중복됨)");
            }
            carNameSet.add(s);
        }
    }
}
