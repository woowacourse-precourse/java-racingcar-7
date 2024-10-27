package racingcar.model;

import racingcar.exception.ErrorCode;

public class Car {

    private String name;

    private int moveCount;

    public Car(final String name){
        checkValidateName(name);
        this.name = name;
        this.moveCount = 0;
    }

    private void checkValidateName(final String name) {

        if(name.length()>5){
            throw new IllegalArgumentException(ErrorCode.CANT_CAR_NAME_LENGTH_EXCEED_FIVE.getMessage());
        }

        if(name==null || name.isBlank()){
            throw new IllegalArgumentException(ErrorCode.CANT_CONVERT_CAR_NAME_WITH_NULL_OR_BLANK.getMessage());
        }
    }

    public void moveForward(){
        this.moveCount++;
    }

    public String getName(){
        return this.name;
    }

    public int getMoveCount(){
        return this.moveCount;
    }

}
