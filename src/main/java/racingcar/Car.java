package racingcar;

import utils.ExceptionMessages;

public class Car {
    private final int MAX_NAME_LENGTH = 5;

    String name;
    Integer forwardCnt;

    Car(String name, Integer forwardCnt) {
        validateName(name);
        this.name = name;
        this.forwardCnt = forwardCnt;
    }

    private void validateName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_INPUT);
        }

        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessages.NAME_LENGTH_LIMIT_EXCEEDED);
        }
    }


