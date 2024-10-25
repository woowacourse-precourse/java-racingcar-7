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

    public void isNotEmpty(List<String> carNameList){
        if(carNameList.contains(null) || carNameList.contains("")){
            throw new IllegalArgumentException("자동차 이름이 빈 값입니다.");
        }
    }

    public void isNameLengthValid(List<String> carNameList){
        boolean hasInvalidName = carNameList.stream().anyMatch(name -> name.length() > 5);
        if(hasInvalidName){
            throw new IllegalArgumentException("이름의 길이는 5자 이하여야 합니다.");
        }
    }

}
