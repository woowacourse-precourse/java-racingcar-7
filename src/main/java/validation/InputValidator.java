package validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public InputValidator(){
    }

    public void validateCarName(final String cars){
        List<String> carNameList = Arrays.asList(cars.split(","));
        isEmptyList(carNameList);
        for(String carName : carNameList){
            isNullOrEmpty(carName);
            isValidCarNameLength(carName);
        }
        hasDuplicateCarName(carNameList);
    }

    private void isEmptyList(List<String> carList){
        if(carList.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private void isNullOrEmpty(String carName){
        if(carName == null || carName.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private void isValidCarNameLength(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException();
        }
    }

    private void hasDuplicateCarName(List<String> carList){
        Set<String> nameSet = new HashSet<>();
        for(String carName : carList){
            if(!nameSet.add(carName)){
                throw new IllegalArgumentException();
            }
        }
    }

}
