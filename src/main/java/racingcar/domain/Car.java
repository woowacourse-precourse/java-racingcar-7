package racingcar.domain;


import racingcar.constants.Constants;
import racingcar.vaildation.Vaild;

public class Car {

    private final String name;

    private int position;

    public Car(String name) {
        Vaild.validateCarName(name);
        this.name = name;
        this.position = 0;
    }

    public void moveTry(int number) {
        if (number >= Constants.MOVE_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
