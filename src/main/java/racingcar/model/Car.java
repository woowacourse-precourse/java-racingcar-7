package racingcar.model;

import racingcar.Constants;
import racingcar.Util;

import static racingcar.Constants.*;

public class Car {
    private final String carName;
    private int positionNum=0;

    public Car(String name) {
        this.carName = name;
    }

    public String getName() {
        return carName;
    }

    public void go(){
        if(Util.randomNum() >= GO_NUMBER) {
            positionNum++;
        }
    }
    public int getPositionNum() {
        return positionNum;
    }

    public String playResult(){
        return carName+" : "+"-".repeat(positionNum);
    }
}
