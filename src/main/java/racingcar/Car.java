package racingcar;

public class Car {

    String carName;

    int tryCount;

    public Car(String carName, int tryCount){
        this.carName = carName;
        this.tryCount = tryCount;
    }

    public String getCarName(){
        return carName;
    }

}
