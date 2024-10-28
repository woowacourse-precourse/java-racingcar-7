package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int movevalue;
    public Car(String name, int movevalue) {
        this.name = name;
        this.movevalue = movevalue;
    }
    public String getName() {
        return name;
    }
    public int getMovevalue() {
        return movevalue;
    }
    public void move_car(){
        if(Randoms.pickNumberInRange(0,9)>=4) movevalue++;
    }
}
