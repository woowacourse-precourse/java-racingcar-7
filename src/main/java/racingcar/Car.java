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

    public void moveForward(){
        for(int i=0;i<tryCount;i++){
            if(randomGenerator.getRandomNumber()>=4)
            this.forwardCount++;
        }
    }

}
