package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name;
    public int pos;

    public Car(String name) {
        this.name = name;
        this.pos = 0;
    }

    public void go() {
        if(Randoms.pickNumberInRange(0, 9) >= 4)
            this.pos++;
    }
}
