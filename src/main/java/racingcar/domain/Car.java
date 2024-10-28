package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int currentProgress;

    public Car(String carName) {
        this.carName = carName;
        currentProgress = 0;
    }

    public int move(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) return ++currentProgress;
        return currentProgress;
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentProgress() {
        return currentProgress;
    }
}
