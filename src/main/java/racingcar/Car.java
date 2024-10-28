package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int moveCount;

    public Car(String carName){
        setCarName(carName);
        setMoveCount(0);

    }

    public String getCarName() {
        return carName;

    }

    private void setCarName(String carName) {
        this.carName = carName;

    }

    public int getMoveCount() {
        return moveCount;
    }

    private void setMoveCount(int moveCount) {
        this.moveCount = moveCount;

    }

    public void moveCar(){
        int randomVal = Randoms.pickNumberInRange(0, 10);
        if(randomVal >= 4)
            setMoveCount(this.moveCount + 1);

    }

}
