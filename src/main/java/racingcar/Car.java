package racingcar;

public class Car {
    String carName;
    int carLocation;

    public Car(String carName, int carLocation) {
        this.carName = carName;
        this.carLocation = carLocation;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarLocation() {
        return carLocation;
    }

    public void goFront(){
        carLocation++;
    }

}
