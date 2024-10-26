package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    String carName;
    int randomNumber;
    List<Character> moveCount = new ArrayList<>();

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", randomNumber=" + randomNumber +
                ", moveCount=" + moveCount +
                '}';
    }

    public List<Character> getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(List<Character> moveCount) {
        this.moveCount = moveCount;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
}
