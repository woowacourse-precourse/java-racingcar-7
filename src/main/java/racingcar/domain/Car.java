package racingcar.domain;

public class Car {
    private int position = 0;

    public void moveForward(){
        this.position += 1;
    }

    public int getPosition() {
        return position;
    }
}