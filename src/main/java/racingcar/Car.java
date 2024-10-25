package racingcar;

public class Car {
    private final String name;
    int movedAmount;

    public Car(String name) {
        this.name = name;
        this.movedAmount = 0;
    }

    public String getName() {
        return name;
    }

    public void run() {
        int randomNumber = Utils.generateRandomValue();

        if (Utils.checkMoveCondition(randomNumber)) {
            moveForward();
        }
    }

    private void moveForward() {
        ++movedAmount;
    }
}