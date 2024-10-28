package racingcar.model;

import racingcar.util.MessageFormatter;

public class Car {

    private static final int MINIMUM_NUMBER_TO_ADVANCE = 4;

    private String name;
    private int status;

    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void race(int randomNumber) {
        if (randomNumber >= MINIMUM_NUMBER_TO_ADVANCE) {
            status++;
        }
    }

    public String getInformation() {
        return MessageFormatter.getCarInformation(name, status);
    }
}
