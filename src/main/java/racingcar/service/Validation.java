package racingcar.service;

import java.util.HashMap;
import java.util.List;

public class Validation {
    public Validation() {
    }

    public void validateString(List<String> carNames) {
        try {
            for (String name : carNames) {
                checkStringLength(name);
            }
            checkDuplicationName(carNames);
        } catch (IllegalArgumentException err) {
            throw err;
        }
    }

    public void checkDuplicationName(List<String> carNames){
        HashMap<String, Integer> checkDuplication = new HashMap<>();
        try{
            for (String carName : carNames) {
                if(checkDuplication.containsKey(carName)){
                    throw new IllegalArgumentException("자동차 이름이 중복 되었습니다.");
                }else{
                    checkDuplication.put(carName,1);
                }
            }
        }catch(IllegalArgumentException err){
            throw err;
        }
    }
    private void checkStringLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자를 넘었습니다.");
        }else if( name.isBlank()){
            throw new IllegalArgumentException("자동차 이름이 공백으로 입력되었습니다.");
        }
    }
}
