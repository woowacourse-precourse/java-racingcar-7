package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final Name car;
    private int status;

    public Car (Name name){
        this.car = name;
    }

    public int getStatus(){
        return status;
    }

    public void move() {
        move(getRandomNum());
    }

    public void move(int num){
        if (num >= 4) {
            status++;
        }
    }

    private int getRandomNum () {
        int num = Randoms.pickNumberInRange(0, 9);
        return num;
    }

    public String printStatus(){
        return car + " : " + "-".repeat(status);
    }

    @Override
    public String toString() {
        return String.valueOf(car);
    }
}
