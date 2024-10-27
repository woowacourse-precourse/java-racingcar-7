package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class Car {
    private CarName name;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = 0;
    }

    public String getName() {
        return this.name.getCarName();
    }

    public int getPosition() {
        return this.position;
    }

    public HashMap<String, Integer> randomlyMoveForward() {
        if (checkBiggerThanFour()) {
            moveForward();
        }

        HashMap<String, Integer> nameAndPosition = new HashMap<>();
        nameAndPosition.put(name.getCarName(), position);
        return nameAndPosition;
    }

    public boolean checkBiggerThanFour() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        }
        return false;
    }

    public int moveForward() {
        return ++position;
    }
}
