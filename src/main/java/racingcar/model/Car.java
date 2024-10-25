package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private String moveCount;
    private int moving;

    public Car(String name, String moveCount) {
        this.name = name;
        this.moveCount = moveCount;
        this.moving = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getMoveCount() {
        return this.moveCount;
    }

    private void Move() {
        this.moving++;
    }

    public void tryMoving() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            Move();
        }
    }

    public String getMovingDisplay() {
        return "-".repeat(moving); // 현재 이동 수만큼 '-' 반환
    }

    public int getMoving() {
        return this.moving;
    }
}
