package racingcar.model.component;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if(Randoms.pickNumberInRange(0,9) >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


    // !!! TEST CODE ONLY !!!
    public void setPosition(int position) {
        this.position = position;
    }
}


