package racingcar.domain;

import random.RandomGenerate;

public class Car{

    private String carName;
    private int position;
    private final int carCanMove = 4;
    private RandomGenerate randomGenerate;

    public Car(String carName, RandomGenerate randomGenerate){
        this.carName = carName;
        this.randomGenerate = randomGenerate;
    }

    public void carMove(){
        if(randomGenerate.generateRandomNumber() >= carCanMove)
            this.position++;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return carName;
    }

}
