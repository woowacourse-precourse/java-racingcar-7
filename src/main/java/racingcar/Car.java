package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private String forwardProgress;
    private int forwardProgressLength;
    private int pickNumber;

    public Car(String name) {
        this.name = name;
        this.forwardProgress = "";
    }

    public void move() {
        pickNumber = Randoms.pickNumberInRange(0, 9);
        if (pickNumber >= 4) {
            forwardProgress += "-";
            forwardProgressLength = forwardProgress.length();
        }
        printForwardProgress();
    }

    private void printForwardProgress() {
        System.out.println(name + " : " + forwardProgress);
    }

    public int getForwardProgressLength() {
        return forwardProgressLength;
    }

    public String isWinner(int max) {
        if (max == forwardProgressLength) {
            return name;
        }
        return "";
    }
}
