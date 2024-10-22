package racingcar.domain;

import static racingcar.exception.ExceptionMessage.ILLEGAL_POSITION;

public class Position {
    private int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if(position < 0){
            throw new IllegalArgumentException(ILLEGAL_POSITION.getMessage());
        }
    }

    public void stop(){

    }

    public void forward(){
        position++;
    }

    public int getPosition(){
        return position;
    }
}
