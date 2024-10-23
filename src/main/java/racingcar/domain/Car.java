package racingcar.domain;

import racingcar.exception.RaceException;
import racingcar.utility.StringUtility;

public class Car {

    private final String INVALID_CAR_NAME_MESSAGE = "유효하지 않은 자동차 이름입니다. (특수문자 사용불가)";
    private final String name;
    private int move;

    public Car(String name) {
        if(!isNameValid(name)){
            throw new RaceException(INVALID_CAR_NAME_MESSAGE);
        }
        this.name = name;
        this.move = 0;
    }

    private boolean isNameValid(String name) {
        return !StringUtility.containsSpecialCharacter(name);
    }

    public int getMove() {
        return move;
    }

    public String getName() {
        return name;
    }

    public void move(){
        this.move++;
    }
}
