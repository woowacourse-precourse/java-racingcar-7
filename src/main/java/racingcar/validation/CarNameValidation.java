package racingcar.validation;

import java.util.HashSet;
import java.util.List;

public class CarNameValidation {
    public void isNotDuplicate(List<String> carNameList){
        HashSet<String> carNameSet = new HashSet<>(carNameList);
        if(carNameList.size() != carNameSet.size()){
            throw new IllegalArgumentException("중복된 이름이 존재하지 않아야 합니다.");
        }
    }
}
