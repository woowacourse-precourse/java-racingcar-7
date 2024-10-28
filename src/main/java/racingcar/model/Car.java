package racingcar.model;

import racingcar.utils.ErrorCode;

public class Car {
    private MoveCondition moveCondition;
    private final String name;
    private Long position;

    public Car(String name) {
        validateName(name);

        this.moveCondition = new MoveCondition(4);
        this.name = name;
        this.position = 0L;
    }

    private Boolean validateName(String name){
        if(name.isEmpty())
            throw new IllegalArgumentException(ErrorCode.NAME_EMPTY_ERROR.getMessage());
        if (name.length() > 5)
            throw new IllegalArgumentException(ErrorCode.NAME_LENGTH_ERROR.getMessage());

        return Boolean.TRUE;
    }

    public void run() {
        if (moveCondition.isSatisfied())
            move();
    }

    private void move(){
        this.position += 1;
    }

    public String getName(){
        return this.name;
    }
    public Long getPosition(){
        return this.position;
    }
}
