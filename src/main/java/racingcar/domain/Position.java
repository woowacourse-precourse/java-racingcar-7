package racingcar.domain;

import static racingcar.exception.ExceptionMessage.ILLEGAL_POSITION;

public class Position {
    private int value;

    public Position(int value) {
        validatePosition(value);
        this.value = value;
    }

    private void validatePosition(int position) {
        if(position < 0){
            throw new IllegalArgumentException(ILLEGAL_POSITION.getMessage());
        }
    }

    public void forward(){
        value++;
    }

    public int getValue(){
        return value;
    }
}
