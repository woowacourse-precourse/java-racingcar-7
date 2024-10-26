package racingcar.domain;

public class Car {

    private static final int MOVE_ABLE_NUM = 4;
    private final String name;
    private int moveCnt;

    private Car(final String name) {
        this.name = name;
        moveCnt = 0;
    }

    public static Car create(final String name) {
        return new Car(name);
    }

    public void moveOrNothing(final int randomNum) {
        if (randomNum >= MOVE_ABLE_NUM) {
            moveForward();
        }
    }

    private void moveForward() {
        this.moveCnt++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

}
