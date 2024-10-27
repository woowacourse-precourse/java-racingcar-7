package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        if(validateMove())
            location++;
    }

    private boolean validateMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }

    public String getName(){
        return name;
    }

    public int getLocation(){
        return location;
    }
}
