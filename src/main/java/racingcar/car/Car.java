package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;

    public String getName() {
        return name;
    }

    public Car(String name) {
        this.name = name;
    }

    private StringBuilder moveHistory = new StringBuilder();

    public String getMoveHistory() {
        return moveHistory.toString();
    }

    public void move() {
        boolean isMove = canMove();
        if (isMove) {
            moveHistory.append("-");
        }
        System.out.println(name + " : " + moveHistory);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
