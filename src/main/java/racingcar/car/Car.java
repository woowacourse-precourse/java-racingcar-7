package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public void attemptMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            moveCount++;
        }
    }

    public void attemptMove(int randomNumber) {
        if (randomNumber >= 4) {
            moveCount++;
        }
    }

    public void showStatus() {
        String moveStatus = moveCountToHyphen();
        printStatus(moveStatus);
    }

    private String moveCountToHyphen() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < moveCount; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    private void printStatus(String moveStatus) {
        System.out.println(name + " : " + moveStatus);
    }

}