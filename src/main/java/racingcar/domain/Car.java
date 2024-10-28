package racingcar.domain;

import static racingcar.util.Message.ErrorMessage.NAME_MAX_LENGTH_ERROR;
import static racingcar.util.Message.ErrorMessage.NAME_MIN_LENGTH_ERROR;

public class Car implements Raceable {
    private final static int STEP_SIZE = 1;
    private final static char DISTANCE_SYMBOL = '-';
    private final static int NAME_MAX_LEGNTH = 5;
    private final static int NAME_MIN_LEGNTH = 1;
    private final String name;
    private int moveCount;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.moveCount = 0;
    }

    @Override
    public void moveFoward() {
        this.moveCount += STEP_SIZE;
    }

    @Override
    public String getCurrentDistance() {
        StringBuilder progressBuilder = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            progressBuilder.append(DISTANCE_SYMBOL);
        }
        return progressBuilder.toString();
    }

    public String getName(){
        return this.name;
    }

    public int getMoveCount(){
        return this.moveCount;
    }

    private void validateNameLength(String name){
        if(name.length() > NAME_MAX_LEGNTH) {
            throw new IllegalArgumentException(NAME_MAX_LENGTH_ERROR);
        }else if(name.length() < NAME_MIN_LEGNTH){
            throw new IllegalArgumentException(NAME_MIN_LENGTH_ERROR);
        }
    }
}
