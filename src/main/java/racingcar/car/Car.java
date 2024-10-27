package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.name.Name;

public class Car {

    private final Name name;
    private int status;

    public Car (Name name){
        this.name = name;
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
        return name + " : " + "-".repeat(status);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
