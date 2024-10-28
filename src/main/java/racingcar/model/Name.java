package racingcar.model;

import static racingcar.common.ErrorMessage.NOT_CAR_NAME_OVER_FIVE;
import static racingcar.common.ErrorMessage.NOT_NULL_AND_NOT_BLANK;

public class Name {
    private final String name;
    private Name(String name){
        validateNullAndBlank(name);
        validateLength(name);
        this.name = name;
    }
    public static Name from(String name){
        return new Name(name);
    }
    private void validateNullAndBlank(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(NOT_NULL_AND_NOT_BLANK.getMessage());
        }
    }

    private void validateLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException(NOT_CAR_NAME_OVER_FIVE.getMessage());
        }
    }

    public String getName(){
        return name;
    }
}
