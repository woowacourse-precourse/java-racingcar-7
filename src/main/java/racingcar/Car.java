package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int forwardLevel;

    public Car() {
        this.forwardLevel = 0;
    }

    public void nameCar(String name) {
        this.name = name;
    }

    public String getCarName() {
        return this.name;
    }

    public int getForwardLevel() {
        return this.forwardLevel;
    }

    public void printForwardLevel() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.forwardLevel; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void forward() {
        this.forwardLevel += 1;
    }

    public boolean isForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
