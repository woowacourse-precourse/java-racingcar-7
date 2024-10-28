package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int STANDARD_NUM = 4;

    private final CarName carName;
    private MoveCount moveCount;

    public Car(String name) {
        this.carName = new CarName(name);
        this.moveCount = new MoveCount(0);
    }

    public void print() {
        carName.print();
        System.out.print(" : ");
        moveCount.print();
    }

    public void carNamePrint() {
        carName.print();
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= STANDARD_NUM){
            moveCount = moveCount.add();
        }
    }

    public MoveCount getMoveCount() {
        return moveCount;
    }

    public boolean isWinner(MoveCount maxMoveCount) {
        return moveCount.equals(maxMoveCount);
    }
}
