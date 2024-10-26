package racingcar.domain;

import random.RandomGenerate;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final int startIndex = 0;
    private List<Car> carList;
    private RandomGenerate randomGenerate;
    private final int maxCarNumber = 5;

    public Cars(List<String> inputNames, RandomGenerate randomGenerate){
        this.randomGenerate = randomGenerate;
        Car[] carArray = new Car[maxCarNumber];

        for(int i = startIndex; i < inputNames.size(); i++){
            Car car = new Car(inputNames.get(i), randomGenerate);
            carArray[i] = car;
        }

        carList = List.of(carArray);
    }

    public void carsMoveN(int numberOfMove){
        for(int i = startIndex; i < numberOfMove; i++){
            carsMove();
        }
    }

    private void carsMove(){
        for(int i = startIndex; i < carList.size(); i++){
            Car car = carList.get(i);
            car.carMove();
        }
    }

}
