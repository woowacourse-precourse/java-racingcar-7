package racingcar;

import java.util.ArrayList;

public class RacingCar {
    private String name;
    private int position;
    private ArrayList<Boolean> moveCondition;
    static int racingCounter = InputHandler.getRacingCounter();

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
        this.moveCondition = RacingController.setMoveCondition(racingCounter);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Boolean> getMoveCondition() {
        return moveCondition;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position += 1;
    }
}
