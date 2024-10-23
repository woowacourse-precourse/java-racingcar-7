package racingcar;

public class Car {
    String carName;
    int carLocation;
    public Car(String carName, int carLocation) {
        this.carName = carName;
        this.carLocation = carLocation;
    }

    public void goFront(){
        //random 4이상일경우
        carLocation++;
    }

}
