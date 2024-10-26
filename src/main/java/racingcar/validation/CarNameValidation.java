package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import racingcar.message.Message;

public class CarNameValidation {

    public void isNotDuplicate(List<String> carNameList){
        HashSet<String> carNameSet = new HashSet<>(carNameList);
        if(carNameList.size() != carNameSet.size()){
            throw new IllegalArgumentException(Message.duplicateName.getMessage());
        }
    }

    public void isNotEmpty(List<String> carNameList){
        if(carNameList.contains(null) || carNameList.contains("")){
            throw new IllegalArgumentException(Message.emptyName.getMessage());
        }
    }

    public void isNameLengthValid(List<String> carNameList){
        boolean hasInvalidName = carNameList.stream().anyMatch(name -> name.length() > 5);
        if(hasInvalidName){
            throw new IllegalArgumentException(Message.lengthLimit.getMessage());
        }
    }

}
