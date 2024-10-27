package racingcar;

import racingcar.util.RandomGenerator;

public class Car {

    String carName;
    int tryCount;
    int forwardCount = 0;

    private RandomGenerator randomGenerator = new RandomGenerator();

    public Car(String carName, int tryCount){
        this.carName = carName;
        this.tryCount = tryCount;
    }

    public String getCarName(){
        return carName;
    }

    public int getTryCount(){
        return tryCount;
    }

    public int getForwardCount(){
        return forwardCount;
    }

    public void moveForward(){
        if(tryCount > 0)
            if(randomGenerator.getRandomNumber()>=4) {
                this.forwardCount++;
                this.tryCount--;
            }
        }


}
