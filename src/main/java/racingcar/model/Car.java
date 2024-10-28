package racingcar.model;

import racingcar.Constants;
import racingcar.Util;

import static racingcar.Constants.*;

public class Car {
    private final String carName;
    private int positionNumber=0;

    public Car(String name) {
        this.carName = name;
    }

    public String getName() {
        return carName;
    }

    public void go(){
        if(Util.randomNumber() >= GO_NUMBER) {
            positionNumber++;
        }
    }
    public int getPositionNumber() {
        return positionNumber;
    }

    public String playResult(){
        return carName+" : "+"-".repeat(positionNumber);
    }

    public boolean isWinner(int maxPosition){
        return positionNumber==maxPosition;
    }
}
