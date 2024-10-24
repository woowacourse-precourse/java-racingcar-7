package racingcar;

public class Car {
    final String name;
    int movedAmount;

    public Car(String name) {
        this.name = name;
        this.movedAmount = 0;
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