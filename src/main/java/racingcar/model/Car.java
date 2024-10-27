package racingcar.model;

import java.awt.event.MouseEvent;
import racingcar.model.move.MoveStrategy;

public class Car {
    private final String name;
    private MoveStrategy moveStrategy;
    private int position;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.canMove()) {
            position++;
        }
    }

}
